package org.yolotest.test.configs;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.yolotest.test.dtos.game.GameRequestDto;
import org.yolotest.test.dtos.game.WinDto;
import org.yolotest.test.services.GameService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@TestConfiguration
public class GameServiceImplTestContextConfiguration {
    @Bean
    public GameService gameServiceAlwaysWin () {
        return new GameService() {
            public WinDto playGame(GameRequestDto gameRequestDto) {
                // initialize win
                BigDecimal win = BigDecimal.ZERO;

                // generate random int between 1 and 100 (both included)
                int randomNum = gameRequestDto.number() + 1;

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

    @Bean
    public GameService gameServiceAlwaysLose () {
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
