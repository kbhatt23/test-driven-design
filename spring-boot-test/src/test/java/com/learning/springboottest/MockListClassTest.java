package com.learning.springboottest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
//setting up manually
//@RunWith(MockitoJUnitRunner.class)
public class MockListClassTest {

	//when not using mock we have to setup manually
	//no need to run with
	//@Mock
	private List<String> listItems = Mockito.mock(List.class);
	
	@Test
	public void testSizeBasic() {
		Mockito.when(listItems.size()).thenReturn(7);
		int sizeResult = listItems.size();
		assertEquals(7, sizeResult);
	}
	
	@Test
	public void testSizeTwice() {
		Mockito.when(listItems.size()).thenReturn(7).thenReturn(8).thenReturn(9);
		int sizeResult = listItems.size();
		assertEquals(7, sizeResult);
		assertEquals(8, listItems.size());
		assertEquals(9, listItems.size());
		//after three times it will keep on sending last value whihc is 9
		assertEquals(9, listItems.size());
		assertEquals(9, listItems.size());
	}
	
	@Test
	public void testWithParameter() {
		Mockito.when(listItems.get(0)).thenReturn("jai shree ram");
		assertEquals("jai shree ram", listItems.get(0));
		
		assertEquals("jai shree ram", listItems.get(0));
		assertEquals(null, listItems.get(1));
	}
	
	@Test
	public void testWithParameterAnyParameter() {
		Mockito.when(listItems.get(Mockito.anyInt())).thenReturn("jai shree ram");
		assertEquals("jai shree ram", listItems.get(0));
		
		assertEquals("jai shree ram", listItems.get(0));
		assertEquals("jai shree ram", listItems.get(1));
	}
}
