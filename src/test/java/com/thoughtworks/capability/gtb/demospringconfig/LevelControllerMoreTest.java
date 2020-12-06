package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "levelNumber = 2")
public class LevelControllerMoreTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_get_advanced_level_when_num_more_than_one() throws Exception {
        mockMvc.perform(get("/level"))
                .andExpect(content().string("advanced"));
    }
}
