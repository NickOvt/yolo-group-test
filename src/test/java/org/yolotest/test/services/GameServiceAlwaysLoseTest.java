package org.yolotest.test.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.yolotest.test.dtos.game.GameRequestDto;
import org.yolotest.test.dtos.game.WinDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameServiceAlwaysLoseTest {
    @TestConfiguration
    static class GameServiceImplTestContextConfiguration {
        @Bean
        public GameService gameService() {
            return new GameService() {
                public WinDto playGame(GameRequestDto gameRequestDto) {
                    // initialize win
                    BigDecimal win = BigDecimal.ZERO;

                    // generate random int between 1 and 100 (both included)
                    int randomNum = gameRequestDto.number() - 1;

                    // * Win depends on chance: = bet * (99 / (100 - number)),
                    // as an example, if player selected the number 50
                    // and bet 40.5, the win would be 80.19

                    // if randomNum is bigger than the user's number then calculate win
                    // otherwise if less there is no win
                    if (randomNum > gameRequestDto.number()) {
                        win = gameRequestDto.bet().multiply(BigDecimal.valueOf(((float) 99 / (float) (100 - gameRequestDto.number()))));
                        win = win.setScale(2, RoundingMode.HALF_EVEN);
                    }

                    final boolean isWin = !(win.equals(BigDecimal.ZERO));

                    return new WinDto(win, isWin);
                }
            };
        }
    }

    @Autowired
    private GameService gameService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void basic() {
        // given
        GameRequestDto gameRequestDto = new GameRequestDto(50, BigDecimal.valueOf(40.5));

        // when
        WinDto winDto = gameService.playGame(gameRequestDto);

        // then
        assertFalse(winDto.isWin());
        assertEquals(BigDecimal.ZERO, winDto.winScore());
    }

    @Test
    void basicTwo() {
        // given
        GameRequestDto gameRequestDto = new GameRequestDto(21, BigDecimal.valueOf(35.987));

        // when
        WinDto winDto = gameService.playGame(gameRequestDto);

        // then
        assertFalse(winDto.isWin());
        assertEquals(BigDecimal.ZERO, winDto.winScore());
    }

    @Test
    void basicThree() {
        // given
        GameRequestDto gameRequestDto = new GameRequestDto(99, BigDecimal.valueOf(19.9999));

        // when
        WinDto winDto = gameService.playGame(gameRequestDto);

        // then
        assertFalse(winDto.isWin());
        assertEquals(BigDecimal.ZERO, winDto.winScore());
    }
}
