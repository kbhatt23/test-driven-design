package com.learning.springboottest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboottest.model.Item;

@Service
public class ItemService {

	//later on we will add JPA call from this layer
	@Autowired
	private ItemRepository repository;
	
	public Item findById(int id) {
		System.out.println("ItemService.findById(): finding item for id "+id);
		return new Item(id, "shree ram", 1, -1);
	}
	
	public List<Item> findAll(){
		System.out.println("ItemService.findAll(): finding all items");
		
		//fake business logic just for showing the demo
		return repository.findAll()
						 .stream()
						 .map(i -> {
							 i.setValue(i.getPrice()*i.getQuantity());
							 return i;
						 })
						 .collect(Collectors.toList())
				;
	}
	
	public void saveItem(Item item) {
		repository.save(item);
	}
}
