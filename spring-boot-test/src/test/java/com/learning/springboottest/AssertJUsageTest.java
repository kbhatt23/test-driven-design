package com.learning.springboottest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.springboottest.model.Item;

public class AssertJUsageTest {

	@Test
	public void sampleHamcrest() throws IOException {
		List<Integer> resultList = Arrays.asList(1,3,4,52,1,1,9);
		Item item = new Item();
		item.setId(10006);
		item.setName("lakshmi narayan");
		item.setPrice(1000);
		item.setQuantity(1);
		ObjectMapper mapper = new ObjectMapper();
		String itemStr =mapper.writeValueAsString(item);
		
		
		System.out.println("val string "+itemStr);
		
		Item fetchedITem =mapper.readValue(itemStr, Item.class);
		System.out.println(fetchedITem);
		
		//chaining is allowed and hence it is easier to read and less code to be written
		assertThat(resultList).hasSize(7)
								.contains(1,4,9)
								.allMatch(i -> i > 0)
								;
		
		//assertThat(resultList, hasSize(7));
		//assertThat(resultList, hasItems(1,3,9));
		//assertThat(resultList, everyItem(greaterThan(0)));
		
		//assertThat("", isEmptyString());
		//assertThat("ABCDEF", startsWith("AB"));
		//assertThat("ABCDEF", endsWith("DEF"));
	}
	
}
