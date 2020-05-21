package com.learning.springboottest.service;

public class DataProviderStub implements DataProvider{

	@Override
	public int[] retrieveNumbers() {
		return new int[] {1,4,5,6,7};
	}

	@Override
	public int[] retrieveNumbers(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] retrieveNumbers(String item1, String item2, int times) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
