package org.yolotest.test.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private HelloController helloController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    void helloWorldRoot() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/public"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from the server"));
    }

    @Test
    void helloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/public/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from the server"));
    }
}
