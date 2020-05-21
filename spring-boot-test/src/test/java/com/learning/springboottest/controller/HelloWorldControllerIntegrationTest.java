package com.learning.springboottest.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

//integration test needs to load whole application based on @springbootapplication class
//app temporarily runns on a random port(or defined port) and after test the porces is cleaned
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HelloWorldControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void helloWorldBasic() {
		String result = restTemplate.getForObject("/hello-world", String.class);
		//return is string itlself so no need of jsonassert
		assertEquals("Jai Shree Ram", result);
	}
}
