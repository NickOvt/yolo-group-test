package org.yolotest.test.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.yolotest.test.dtos.game.GameRequestDto;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class GameControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private GameController gameController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void gameControllerNoFieldsSuppliedBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/public/game").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(new GameRequestDto(null, null))))
                .andExpect(status().isBadRequest());
    }

    @Test
    void gameControllerBetSuppliedBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/public/game").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(new GameRequestDto(null, BigDecimal.TEN))))
                .andExpect(status().isBadRequest());
    }

    @Test
    void gameControllerNumberSuppliedBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/public/game").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(new GameRequestDto(10, null))))
                .andExpect(status().isBadRequest());
    }

    @Test
    void gameControllerAllSuppliedIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/public/game").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(new GameRequestDto(10, BigDecimal.TEN))))
                .andExpect(status().isOk());
    }
}
