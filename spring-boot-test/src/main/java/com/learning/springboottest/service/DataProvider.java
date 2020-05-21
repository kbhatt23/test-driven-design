package com.learning.springboottest.service;

public interface DataProvider {

	int[] retrieveNumbers();
	
	int[] retrieveNumbers(String item);
	
	int[] retrieveNumbers(String item1,String item2, int times);
		
}
