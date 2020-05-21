package com.learning.springboottest.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.springboottest.model.Item;
import com.learning.springboottest.service.ItemRepository;
import com.learning.springboottest.service.ItemService;

@RunWith(SpringRunner.class)
//no need of injecting ItemService as we are mocking it anyway
@WebMvcTest(value = { ItemController.class /* , ItemService.class, ItemRepository.class */})
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMVC;
	
	//@mock is not working
	//@Mock
	@MockBean
	private ItemService itemService;
	
	@MockBean
	private ItemRepository repo;
	
	@Test
	public void createSampleItemBasic() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items/test").accept(MediaType.APPLICATION_JSON);
								
		String response = mockMVC.perform(requestBuilder)
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		;
		assertEquals("{\"id\":1,\"name\":\"raghav\",\"quantity\":1,\"price\":-1,\"value\":0}", response);
		
		mockMVC.perform(requestBuilder)
				.andExpect(status().isOk())
				//better to use json ,  as string matched character by character and any space will make it false
				//.andExpect(content().string("{\"id\":1, \"name\":\"raghav\",\"quantity\":1,\"price\":-1}"));
				.andExpect(content().json("{\"id\":1, \"name\":\"raghav\"}"));
	}
	
	@Test
	public void findITemById() throws Exception {
		Mockito.when(itemService.findById(Mockito.anyInt()))
				.thenReturn(new Item(10, "shree krishna", 1, -1));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items/3").accept(MediaType.APPLICATION_JSON);
		String actual = mockMVC.perform(requestBuilder)
				.andExpect(status().isOk())
				.andReturn()
				.getResponse().getContentAsString()
				;
		//minimum [properties in actual should be present in expected str
		//, extra properties present in actual can be ignored
		//String expectedStr = "{\"id\":10,\"name\":\"sita ram\",\"quantity\":1,\"price\":-1}";
		//ignoring name to test strictness policy
		String expectedStr = "{\"id\":10,\"quantity\":1,\"price\":-1}";
		JSONAssert.assertEquals(expectedStr, actual, false);
	}
	
	@Test
	public void findAll() throws Exception {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1,"sita ram", 1, 32));
		Mockito.when(itemService.findAll()).thenReturn(items);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON);
		mockMVC.perform(requestBuilder)
				.andExpect(status().isOk())
				//by default strictness is false -> meaning even extra properties in result will be ignored mandaotry will,be extpected proeprties
				.andExpect(content().json("[{\"id\":1,\"name\":\"sita ram\",\"quantity\":1,\"price\":32}]"));
		
		
		;
		Mockito.verify(itemService,Mockito.never()).findById(Mockito.anyInt());
		Mockito.verify(itemService,Mockito.times(1)).findAll();
		
	}
	
	@Test
	public void createItem() throws UnsupportedEncodingException, Exception {
		Item item = new Item();
		item.setId(10006);
		item.setName("lakshmi narayan");
		item.setPrice(1000);
		item.setQuantity(1);
		ObjectMapper mapper = new ObjectMapper();
		String itemStr =mapper.writeValueAsString(item);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/items")
															.contentType(MediaType.APPLICATION_JSON)
															.content(itemStr)
															.accept(MediaType.APPLICATION_JSON)
															;
		
		
				;
		Mockito.when(repo.save(Mockito.anyObject())).thenReturn(item);		
				
		String resultJson = mockMVC.perform(requestBuilder)
				.andExpect(status().isCreated())
				.andReturn().getResponse().getContentAsString();
		String expectedStr = "{\"id\":10006,\"name\":\"lakshmi narayan\",\"quantity\":1,\"price\":1000}";
		JSONAssert.assertEquals(expectedStr, resultJson, false);
	}
}
