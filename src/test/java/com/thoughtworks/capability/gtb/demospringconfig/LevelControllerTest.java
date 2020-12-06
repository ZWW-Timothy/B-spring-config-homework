package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class LevelControllerTest {

    @Autowired
    private LevelController levelController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_get_basic_level_when_num_less_than_one() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 0);
        mockMvc.perform(get("/level"))
                .andExpect(content().string("basic"));
    }

    @Test
    public void should_get_advanced_level_when_num_equal_to_one() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 1);
        mockMvc.perform(get("/level"))
                .andExpect(content().string("advanced"));
    }

    @Test
    public void should_get_advanced_level_when_num_more_than_one() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 2);
        mockMvc.perform(get("/level"))
                .andExpect(content().string("advanced"));
    }
}
