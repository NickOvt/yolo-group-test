package org.yolotest.test.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yolotest.test.dtos.game.GameRequestDto;
import org.yolotest.test.dtos.game.WinDto;
import org.yolotest.test.services.GameService;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/rest_api/game")
    public WinDto playGameRest(@RequestBody @Valid GameRequestDto gameRequestDto) {
        return gameService.playGame(gameRequestDto);
    }

    @MessageMapping("/game")
    @SendTo("/topic/game")
    public WinDto playGame (@Valid GameRequestDto gameRequestDto) {
        return gameService.playGame(gameRequestDto);
    }
}
