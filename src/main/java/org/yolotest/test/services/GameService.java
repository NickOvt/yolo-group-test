package org.yolotest.test.services;

import org.springframework.stereotype.Service;
import org.yolotest.test.dtos.game.GameRequestDto;
import org.yolotest.test.dtos.game.WinDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;

@Service
public class GameService {

    private final SecureRandom secureRandom = new SecureRandom();

    public WinDto playGame(GameRequestDto gameRequestDto) {
        // initialize win
        BigDecimal win = BigDecimal.ZERO;

        // generate random int between 1 and 100 (both included)
        int randomNum = secureRandom.nextInt(1, 101);

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
}
