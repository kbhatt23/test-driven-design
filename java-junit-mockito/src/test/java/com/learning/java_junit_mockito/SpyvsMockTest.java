package com.learning.java_junit_mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyvsMockTest {
	List<Integer> mockList = mock(List.class);
	//we need to give actual concrete implemntation as it will call actual method for methods not decsribed in Mockito.when 
	List<Integer> spyList = spy(ArrayList.class);
	
	@Test
	public void testMockList() {
		//default size is 0
		assertEquals(0, mockList.size());
		mockList.add(23);
		//mock do not have methods having actual body
		//mock when not having stub method description return happy values 
		//-> like empty array, empty list, null for objects, 0 for int,false for boolean etc
		assertEquals(0, mockList.size());
		
	}
	
	@Test
	public void testSpyList() {
		//default size is 0
		assertEquals(0, spyList.size());
		spyList.add(23);
		//spy have actual method features for methods for whom stub is not described using mockito.when method
		assertEquals(1, spyList.size());
		spyList.add(23);
		assertEquals(2, spyList.size());
		when(spyList.size()).thenReturn(6);
		//methods overrided by when method always return that
		//other methods will not have default behaviour like mock but will call actual method
		assertEquals(6, spyList.size());
		
	}
	
}
