package com.view.project.Entertainment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Opening.class)
public class OpeningControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testOpen() throws Exception {
        mockMvc.perform(get("/openingparent/open"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to the open page"));
    }

    @Test
    public void testOpendefault() throws Exception {
        mockMvc.perform(get("/openingparent/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to the open default page"));
    }
}

