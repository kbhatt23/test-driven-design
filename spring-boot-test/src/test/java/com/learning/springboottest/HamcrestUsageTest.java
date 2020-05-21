package com.learning.springboottest;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestUsageTest {

	@Test
	public void sampleHamcrest() {
		List<Integer> resultList = Arrays.asList(1,3,4,52,1,1,9);
		
		assertThat(resultList, hasSize(7));
		assertThat(resultList, hasItems(1,3,9));
		assertThat(resultList, everyItem(greaterThan(0)));
		
		assertThat("", isEmptyString());
		assertThat("ABCDEF", startsWith("AB"));
		assertThat("ABCDEF", endsWith("DEF"));
	}
	
}
