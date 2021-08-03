package com.cybertek.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;
//@WebMvcTest(WelcomeController.class) -- executed only what executed 1`better for unit tests of controllers
//@SpringBootTest - executing all context run all beans connect data base for integration tests
@WebMvcTest
class WelcomeControllerTest {
    //this class coming from spring library ( we creating mock server for http not using real one
    @Autowired
    private MockMvc mockMvc;

    @Test
    void welcome() throws Exception {
        // call welcome endpoint and verify output
        //1.building a request @getmapping endpoint welcome
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON);
         // 2. triggering endpoit which we created and saving expecting result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals("welcome",result.getResponse().getContentAsString());
    }


    // second option to do it
    @Test
    void welcome2() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();
    }

}