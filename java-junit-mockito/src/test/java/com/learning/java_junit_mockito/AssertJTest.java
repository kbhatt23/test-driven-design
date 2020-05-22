package com.learning.java_junit_mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class AssertJTest {

	List<String> mockList = Mockito.mock(List.class);
	List<String> normalList = Arrays.asList("ram", "krishna" , "radha" , "lakshami");

	@Test
	public void assertListBasic() {

		assertThat(normalList,hasSize(4));
		assertThat(normalList, hasItem("ram"));
	}
	
	@Test
	public void assertListMock() {

		assertThat(mockList,hasSize(0));
		when(mockList.size()).thenReturn(3);
		assertThat(mockList,hasSize(3));
	}
}
