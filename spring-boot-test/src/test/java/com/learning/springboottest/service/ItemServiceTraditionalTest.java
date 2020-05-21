package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.springboottest.model.Item;

@RunWith(SpringRunner.class)
public class ItemServiceTraditionalTest {

	@InjectMocks
	private ItemService itemService;
	
	@Mock
	private ItemRepository itemRepository;
	
	@Test
	public void findAll() {
		Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "radhe krishna", 1, 108),new Item(1, "sita ram", 1, 101)));
		
		List<Item> actualList = itemService.findAll();
		
		assertEquals(108, actualList.get(0).getValue());
		assertEquals(101, actualList.get(1).getValue());
		
	}
}
