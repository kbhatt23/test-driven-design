package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculationServiceUsingStubsTest {
	private CalculationService service = new CalculationService();
	@Test
	public void calcualateArraySumStubs_Basic(){
		System.out.println("============CalculationServiceTestUsingStubs: started calcualateArraySum=================");
		service.setDataProvider(new DataProviderStub());
		int result = service.calcualateArraySum();
		int expected = 23;
		assertEquals(expected, result);
	}
	
	@Test
	public void calcualateArrayStubsSum_Empty(){
		System.out.println("============CalculationServiceTestUsingStubs: started calcualateArraySum_Empty=================");
		service.setDataProvider(new DataProviderStubEmpty());
		int result = service.calcualateArraySum();
		int expected = 0;
		assertEquals(expected, result);
	}	
}
