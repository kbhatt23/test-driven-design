package com.learning.springboottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboottest.model.Item;
import com.learning.springboottest.model.ItemCopy;
import com.learning.springboottest.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/test")
	public Item createSampleItem() {
		return new Item(1, "raghav", 1, -1);
	}
	
	@GetMapping("/{id}")
	public Item findITemById(@PathVariable int id) {
		return itemService.findById(id);
	}
	
	@GetMapping
	public List<Item> findAll(){
		return itemService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item itemBean){
		itemService.saveItem(itemBean);
		return new ResponseEntity<>(itemBean, HttpStatus.CREATED);
	}
}
