package com.chinexboroja.tacos.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/*Web test for HomeController*/
@WebMvcTest(HomeController.class)
class HomeControllerTest {

    /* Injects MockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        //Performs GET
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) // Expect HTTP 200
                .andExpect(view().name("home")) // Expect Home view
                .andExpect(content().string(
                        containsString("Welcome to...") // Expects Welcome to...
                ));
    }
}