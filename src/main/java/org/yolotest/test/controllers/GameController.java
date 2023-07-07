package org.yolotest.test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.yolotest.test.dtos.GameRequestDto;
import org.yolotest.test.services.GameService;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @MessageMapping("/game")
    @SendTo("/topic/game")
    public BigDecimal playGame (GameRequestDto gameRequestDto) {
        return gameService.playGame(gameRequestDto);
    }
}
