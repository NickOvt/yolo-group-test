package org.yolotest.test.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameServiceRTPTest {

    @Autowired
    private GameService gameService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void givenNoNumberAndBetReturnListOfListsForBoth() {}

}
