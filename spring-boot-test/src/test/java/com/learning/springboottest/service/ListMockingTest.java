package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

public class ListMockingTest {

	//simulating scenarios where list is instance variablke and need to mock that variable
	List<String> listMock = Mockito.mock(List.class);
	@Test
	public void basicTest() {
		Mockito.when(listMock.get(0)).thenReturn("jai shree ram");
		assertEquals("jai shree ram", listMock.get(0));
		assertEquals("jai shree ram", listMock.get(0));
		assertEquals("jai shree ram", listMock.get(0));
		//assertEquals("jai shree ram", listMock.get(1));
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	public void basicTestNtime() {
		Mockito.when(listMock.get(0)).thenReturn("jai shree ram").thenReturn("jai shree krishna")
		.thenReturn("jai shree ram");
		assertEquals("jai shree ram", listMock.get(0));
		assertEquals("jai shree krishna", listMock.get(0));
		assertEquals("jai shree ram", listMock.get(0));
		assertEquals("jai shree ram", listMock.get(0));
	}
	
	@Test
	public void complexTestNtime() {
		Mockito.when(listMock.get(Mockito.anyInt())).thenReturn("jai shree ram").thenReturn("jai shree krishna")
		.thenReturn("jai shree ram");
		assertEquals("jai shree ram", listMock.get(0));
		assertEquals("jai shree krishna", listMock.get(1));
		assertEquals("jai shree ram", listMock.get(2));
		assertEquals("jai shree ram", listMock.get(3));
		assertEquals("jai shree ram", listMock.get(4));
	}
	
	@Test
	public void verifyBasic() {
		listMock.get(0);
		Mockito.verify(listMock).get(0);
		//Mockito.verify(listMock).get(1);
	}
	
	@Test
	public void verifyBasicAnyInt() {
		listMock.get(0);
		listMock.get(2);
		//Mockito.verify(listMock).get(0);
		Mockito.verify(listMock,Mockito.times(2)).get(Mockito.anyInt());
	}
	
	@Test
	public void verifyBasicListAdd() {
		listMock.add("jai shree ram");
		listMock.add("jai shree ram");
		Mockito.verify(listMock, times(2))
				.add(Mockito.anyString());
	}
	
	@Test
	public void verifyCaptor() {
		//below line will be executed in service class
		listMock.add("jai shree ram");
		ArgumentCaptor<String> argumentCaptor= ArgumentCaptor.forClass(String.class);
		
		Mockito.verify(listMock).add(argumentCaptor.capture());
		assertEquals("jai shree ram", argumentCaptor.getValue());
	}
}
