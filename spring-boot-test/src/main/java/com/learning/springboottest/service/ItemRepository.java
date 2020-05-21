package com.learning.springboottest.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboottest.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
