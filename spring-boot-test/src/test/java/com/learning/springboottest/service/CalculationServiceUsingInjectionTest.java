package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculationServiceUsingInjectionTest {
	//no need to have Dependency injection manually
	
	/* private CalculationService service = new CalculationService(); */
	@InjectMocks
	private CalculationService service;
	
	//no need to call mockable class creation manually
	/* DataProvider dataProvider = Mockito.mock(DataProvider.class); */

	@Mock
	DataProvider dataProvider;
	
	//no need to set this
	//as DI from inject mocks take care of this
	/*
	 * @Before public void setDataInstance() {
	 * service.setDataProvider(dataProvider); }
	 */

	@Test
	public void calcualateArraySumStubs_Basic() {
		System.out.println("============CalculationServiceUsingInjectionTest: started calcualateArraySum=================");
		// mockito
		prepareData(new int[] { 1, 4, 5, 6, 7 });

		int result = service.calcualateArraySum();
		int expected = 23;
		assertEquals(expected, result);
	}

	@Test
	public void calcualateArrayStubsSum_Empty() {
		System.out.println(
				"============CalculationServiceUsingInjectionTest: started calcualateArraySum_Empty=================");
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
