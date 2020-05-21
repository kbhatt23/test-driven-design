package com.learning.springboottest.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
@Service
public class CalculationService {
	
	private DataProvider dataProvider;

	public void setDataProvider(DataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public int calcualateArraySum(int[] numbers) {
		
		return Arrays.stream(numbers).sum();
	}
	
	public int calcualateArraySum() {
		int[] numbers = dataProvider.retrieveNumbers();
		return Arrays.stream(numbers).sum();
	}
	//is not returning and hence can not assert
	//need to verify if correct method was called
	public void calculateAndStoreArraySum() {
		int[] numbers = dataProvider.retrieveNumbers();
		int sum =Arrays.stream(numbers).sum();
		this.sum=sum;
		
	}
	
	public void calculateAndStoreArraySumCapture() {
		//we can mock data provider
		//also can capture argument passed
		int[] numbers = dataProvider.retrieveNumbers("jai shree krishna");
		int[] numbers1 = dataProvider.retrieveNumbers("jai shree ram");
		int sum =Arrays.stream(numbers).sum();
		this.sum=sum;
		
	}
	public void calculateAndStoreArraySumCaptureTwice() {
		//we can mock data provider
		//also can capture argument passed
		int[] numbers = dataProvider.retrieveNumbers("jai shree krishna"
				, "jai shree ram" , 108
				);
		int[] numbers1 = dataProvider.retrieveNumbers("jai shree krishna says kannu"
				, "jai shree ram says kannu" , 109
				);
		int sum =Arrays.stream(numbers).sum();
		this.sum=sum;
		
	}
	private int sum;

	public int getSum() {
		return sum;
	}
	
}
