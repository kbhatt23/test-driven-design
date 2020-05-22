package com.learning.java_junit_mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockingBasicsTest {

	List<String> listMock = mock(List.class);
	
	@Test
	public void returnMultipleTimes() {
		
		when(listMock.get(0)).thenReturn("sita ram").thenReturn("raja ram").thenReturn("radha krishna");
		
		assertEquals("sita ram", listMock.get(0));
		assertEquals("raja ram", listMock.get(0));
		assertEquals("radha krishna", listMock.get(0));
		assertEquals("radha krishna", listMock.get(0));
		assertEquals("radha krishna", listMock.get(0));
		//no mock set for this
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	public void returnItemForAnyInput() {
		
		when(listMock.get(anyInt())).thenReturn("sita ram").thenReturn("raja ram").thenReturn("radha krishna");
		assertEquals("sita ram", listMock.get(0));
		assertEquals("raja ram", listMock.get(11));
		assertEquals("radha krishna", listMock.get(12));
		assertEquals("radha krishna", listMock.get(9));
		assertEquals("radha krishna", listMock.get(0));
		//mock set to any int input
		assertEquals("radha krishna", listMock.get(1));
	}
	
	@Test(expected = RuntimeException.class)
	public void testBasicExceptionMock() {
		when(listMock.get(-1)).thenThrow(RuntimeException.class);
		//listMock.get(-2);
		listMock.get(-1);
	}
	
	@Test
	public void fetchArguments() {
		
		when(listMock.get(anyInt())).thenReturn("sita ram");
		assertEquals("sita ram", listMock.get(0));
		assertEquals("sita ram", listMock.get(1));
		assertEquals("sita ram", listMock.get(12));
		//should fail as by default times is 1
		//verify(listMock).get(anyInt());
		verify(listMock).get(0);
		
		verify(listMock,times(3)).get(anyInt());
		
		//arguments
		ArgumentCaptor<Integer> args = ArgumentCaptor.forClass(Integer.class);
		verify(listMock,times(3)).get(args.capture());
		
		assertEquals(0, args.getAllValues().get(0).intValue());
		assertEquals(1, args.getAllValues().get(1).intValue());
		assertEquals(12, args.getAllValues().get(2).intValue());
	}
	
	
}
