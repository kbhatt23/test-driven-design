package com.learning.springboottest.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//inject mockMvc beans which are not present in springboot test: used to call endpoint
//injecting only one controller as this controller is meant to test hellowowrldcontroller only
@WebMvcTest(HelloWorldController.class)
//since we are using spring beans for autowiring
@RunWith(SpringRunner.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Test
	public void helloWorldTest_Basic() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/hello-world")
										.accept(MediaType.APPLICATION_JSON)
										;
		ResultActions result = mockMVC.perform(req);
		String response= result.andExpect(status().isOk())
								.andReturn()
							   .getResponse()
							   .getContentAsString();
		assertEquals("Jai Shree Ram", response);
	}
}
