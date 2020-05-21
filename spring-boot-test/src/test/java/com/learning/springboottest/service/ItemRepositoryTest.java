package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.springboottest.model.Item;

//This is meant to load DB data using scope test
//@springboot test is will load everyting
//we just need DB related beans
@DataJpaTest(showSql = true)
@RunWith(SpringRunner.class)

//no mocking here
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void findAll() {
		List<Item> findAll = itemRepository.findAll();
		assertEquals(5, findAll.size());
		findAll.forEach(item -> assertEquals(1, item.getQuantity()));
	}
	
	
}
