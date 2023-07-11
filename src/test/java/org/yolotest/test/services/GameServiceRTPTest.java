package org.yolotest.test.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yolotest.test.dtos.game.GameRequestDto;
import org.yolotest.test.dtos.game.WinDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@SpringBootTest
class GameServiceRTPTest {

    @Autowired
    private GameService gameService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void givenNoNumberAndBetReturnListOfListsForBoth() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(24);

        BigDecimal totalBet = BigDecimal.ZERO;
        BigDecimal totalWon = BigDecimal.ZERO;

        List<Future<WinDto>> resultList = new ArrayList<>();

        List<GameRequestDto> gameRequestDtoListInitial = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            gameRequestDtoListInitial.add(new GameRequestDto(new Random().nextInt(1, 100), BigDecimal.valueOf(new Random().nextDouble(0.5, 1000))));
        }

        for (GameRequestDto gameRequestDto : gameRequestDtoListInitial) {
            totalBet = totalBet.add(gameRequestDto.bet());
        }

        for (int i = 0; i < 1_000_000; i++) {
            int finalI = i;
            resultList.add(threadPool.submit(() -> {
                // given
                GameRequestDto gameRequestDto = gameRequestDtoListInitial.get(finalI);

                // when
                // ... winDto ...

                // then
                return gameService.playGame(gameRequestDto);
            }));
        }
        threadPool.shutdown();
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        for (Future<WinDto> future : resultList) {
            if (future.isDone()) {
                totalWon = totalWon.add(future.get().winScore());
            }
        }

        System.out.println(totalBet);
        System.out.println(totalWon);
        System.out.println(totalWon.divide(totalBet, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100)) + "%");
    }

}
