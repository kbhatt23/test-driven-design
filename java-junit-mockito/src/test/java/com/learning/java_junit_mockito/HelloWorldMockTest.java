package com.learning.java_junit_mockito;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class HelloWorldMockTest {

	private List<Integer> numbersMock = Mockito.mock(List.class);
	
	//private List<Integer> numbersSpy = Mockito.spy(List.class);
	
	@Test
	public void sampleListMock() {
		numbersMock.add(23);
		System.out.println(numbersMock.get(0));
		System.out.println(numbersMock.size());
		
		Mockito.when(numbersMock.get(0)).thenReturn(23);
		
		System.out.println(numbersMock.get(0));
		System.out.println(numbersMock.get(1));
		System.out.println(numbersMock.size());
	}
}
