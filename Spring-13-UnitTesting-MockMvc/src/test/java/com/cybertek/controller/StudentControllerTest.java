package com.cybertek.controller;

import com.cybertek.entity.Student;
import com.cybertek.service.StudentService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@WebMvcTest(WelcomeController.class) -- executed only what executed 1`better for unit tests of controllers
//@SpringBootTest - executing all context run all beans connect data base for integration tests
@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    //means bring student service bean and mock it if used @SpringBoottest will bring real beans
    @MockBean
    StudentService studentService;

// here we are hard coded not using mock server
     @Test
     void get_Student_data() throws Exception {
         // create mock mvc (create mock endpoint and hit it
         mockMvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON))
                  // now after we hit an endpoint we are expecting get this response below
                 .andExpect(content().json("{\"id\": 0,\"firstName\": \"Mike\",\"lastName\": \"Smith\",\"age\": 20}"))
                 .andReturn();
     }
 // BELOW 2 ways of asserting Json :
 //it's accepting 3 parameters expected actual and false true means strict means check all atributes similar contains method
    @Test
    void jsonAssert() throws JSONException {

        String actual = "{\"id\": 0,\"firstName\": \"Mike\",\"lastName\": \"Smith\",\"age\": 20}";
        String expected = "{\"id\": 0,\"firstName\": \"Mike\",\"lastName\": \"Smith\"}";

        JSONAssert.assertEquals(expected,actual,false);
    }

    @Test
    void jsonAssert_withoutEscapeCharacters() throws JSONException {

        String actual = "{id: 0,firstName:Mike,lastName:Smith,age:20}";
        String expected = "{id:0,firstName:Mike,lastName:Smith}";

        JSONAssert.assertEquals(expected,actual,false);
    }

    // this option we will mocking data layer
    @Test
    void getStudent_data() throws Exception {
     //   simulating db data in a fact studentservice is not triggered
        when(studentService.getStudent_data()).thenReturn(Arrays.asList(
                new Student("ozzy","can",20),
                new Student("tom","hanks",50)
        ));
        // here we go to controller but we are not returning data from db we mock it look above
        mockMvc.perform(MockMvcRequestBuilders.get("/data").accept(MediaType.APPLICATION_JSON))
                // here we are doing verification
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":0,\"firstName\":\"ozzy\",\"lastName\":\"can\",\"age\":20},{\"id\":0,\"firstName\":\"tom\",\"lastName\":\"hanks\",\"age\":50}]"))
                .andReturn();
    }


}