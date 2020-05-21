package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculationServiceUsingMockTest {
	private CalculationService service = new CalculationService();
	DataProvider dataProvider = Mockito.mock(DataProvider.class);

	@Before
	public void setDataInstance() {
		System.out.println("jai shree ram");
		service.setDataProvider(dataProvider);
	}

	@Test
	public void calcualateArraySumStubs_Basic() {
		System.out.println("============CalculationServiceUsingMockTest: started calcualateArraySum=================");
		// mockito
		prepareData(new int[] { 1, 4, 5, 6, 7 });

		int result = service.calcualateArraySum();
		int expected = 23;
		assertEquals(expected, result);
	}

	@Test
	public void calcualateArrayStubsSum_Empty() {
		System.out.println(
				"============CalculationServiceUsingMockTest: started calcualateArraySum_Empty=================");
		prepareData(new int[] {});
		int result = service.calcualateArraySum();
		int expected = 0;
		assertEquals(expected, result);
	}

	private DataProvider prepareData(int[] data) {
		// on each call it is creating new instance of mock
		// we can move it out of method

		Mockito.when(dataProvider.retrieveNumbers()).thenReturn(data);
		return dataProvider;
	}

}
