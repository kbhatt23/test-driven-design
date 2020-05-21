package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.springboottest.model.Item;

@RunWith(SpringRunner.class)
//autowire wont work without it
//we could have used @injectMocks annotatin created by junit library
@SpringBootTest(classes = {ItemService.class})
public class ItemServiceNewTest {

	@Autowired
	private ItemService itemService;
	
	@MockBean
	private ItemRepository itemRepository;
	
	@Test
	public void findAll() {
		Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "radhe krishna", 1, 108),new Item(1, "sita ram", 1, 101)));
		
		List<Item> actualList = itemService.findAll();
		
		assertEquals(108, actualList.get(0).getValue());
		assertEquals(101, actualList.get(1).getValue());
		
	}
}
