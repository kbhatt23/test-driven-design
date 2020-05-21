package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//purpose is to add whole spring cotext of main classes
//add all the beans added in src/main, hence removing for basic test
//@SpringBootTest
public class CalculationServiceTest {
	private CalculationService service = new CalculationService();

	@Test
	public void calcualateArraySum_Basic() {
		System.out.println("============CalculationServiceTest: started calcualateArraySum=================");
		int result = service.calcualateArraySum(new int[] { 1, 4, 5, 6, 7 });
		int expected = 23;
		assertEquals(expected, result);
	}

	@Test
	public void calcualateArraySum_Empty() {
		System.out.println("============CalculationServiceTest: started calcualateArraySum_Empty=================");
		int result = service.calcualateArraySum(new int[] {});
		int expected = 0;
		assertEquals(expected, result);
	}

}
