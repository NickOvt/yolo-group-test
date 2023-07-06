package org.yolotest.test.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.yolotest.test.dtos.GameRequestDto;

@Controller
public class GameController {

    @MessageMapping("/game")
    @SendTo("/topic/game")
    public String playGame (GameRequestDto gameRequestDto) {
        return "received request";
    }
}
