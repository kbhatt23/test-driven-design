package com.learning.springboottest;
//no need of anything

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	private String expectedStr = "{\"id\":1,\"name\":\"raghav\",\"quantity\":1,\"price\":-1}";
	
	private String expectedMissingStr = "{\"id\":1,\"name\":\"raghav\",\"quantity\":1}";
	
	@Test
	public void testAssertStrict() throws JSONException {
		String actual = "{\"id\":1, \"name\":\"raghav\", \"quantity\":1,\"price\":-1}";
		//String actual = "{\"id\":1, \"name\":\"raghav\", \"quantity\":1}";
		
		//josn assert is specially designed for json string assertions
		//meaning spaces can be ignored by default in between
		//but if strict is true all key and values should be same, and nothing can be ignored
		JSONAssert.assertEquals(expectedStr, actual, true);
	}
	
	@Test
	public void testAssertNonStrict() throws JSONException {
		String actual = "{\"id\":1, \"name\":\"raghav\", \"quantity\":1,\"price\":-1}";
		
		//non strict means along with spaces ignoring it also ignores other properties which are missing
		JSONAssert.assertEquals(expectedMissingStr, actual, false);
	}
	
}
