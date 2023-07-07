package org.yolotest.test.services;

import org.springframework.stereotype.Service;
import org.yolotest.test.dtos.GameRequestDto;

import java.math.BigDecimal;

@Service
public class GameService {

    public BigDecimal playGame(GameRequestDto gameRequestDto) {
        return BigDecimal.ONE;
    }
}
