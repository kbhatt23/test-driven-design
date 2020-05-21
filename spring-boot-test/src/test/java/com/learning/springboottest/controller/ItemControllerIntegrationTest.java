package com.learning.springboottest.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.springboottest.model.Item;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	//test shpould be indepedent of actual data, or actual webservice
	//as data in actual DB might change or data in web service might change
	//so we can eitther mock these or create sample stubes for them
	//eg in db we can either mock repo or have a in memeory DB like h2 in test scope
	//this test db can pick data fromdata.sql present in src/test/reseouces
	
	@Test
	public void createSampleItem() throws JSONException {
		String actual = restTemplate.getForObject("/items/test", String.class);
		//result is actually a bean converted to string in json format
		//strict make sure all properties are matched
		//also if response have extra property that is not present in expected, it returns error
		JSONAssert.assertEquals("{\"id\":1,\"price\":-1,    \"name\":\"raghav\", \"quantity\":1,\"value\":0}", actual, true);
		
		JSONAssert.assertEquals("{\"id\":1,\"name\":\"raghav\",\"quantity\":1}", actual, false);
	}
	
	@Test
	public void findITemById() throws JSONException {
		System.out.println("ItemControllerIT.findITemById(): Testing Integration test");
		ItemCopy actual = restTemplate.getForObject("/items/10005", ItemCopy.class);

		assertEquals("shree ram", actual.getName());
		
	}
	
	@Test
	public void saveItem() {
		ItemCopy item = new ItemCopy();
		item.setId(10006);
		item.setName("lakshmi narayan");
		item.setPrice(1000);
		item.setQuantity(1);
		ItemCopy result = restTemplate.postForObject("/items", item, ItemCopy.class);
		//no mocikio as of now
		assertEquals(result.getId(), 10006);
		
	}
	
}
