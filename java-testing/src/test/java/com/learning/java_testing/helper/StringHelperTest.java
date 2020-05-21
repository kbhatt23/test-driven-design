package com.learning.java_testing.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringHelperTest {
	private StringHelper helper = new StringHelper();

	@Test
	public void truncateFirstTwoACharsBasic() {
		String result = helper.truncateFirstTwoAChars("AABC");

		assertEquals("BC", result);
	}
	
	@Test(expected = RuntimeException.class)
	public void truncateFirstTwoACharsNullInput() {
		helper.truncateFirstTwoAChars(null);
		//no need to asser here as anyway expetion shud be thrown
	}
	@Test(expected = RuntimeException.class)
	public void truncateFirstTwoACharsEmptyInput() {
		helper.truncateFirstTwoAChars("");
		//no need to asser here as anyway expetion shud be thrown
	}

	@Test
	public void truncateFirstTwoACharsBasic2() {
		String result = helper.truncateFirstTwoAChars("AA");

		assertEquals("", result);
	}

	@Test
	public void truncateFirstTwoACharsBasic3() {
		String result = helper.truncateFirstTwoAChars("ABC");

		assertEquals("BC", result);
	}

	@Test
	public void truncateFirstTwoACharsBasic4() {
		String result = helper.truncateFirstTwoAChars("BDEC");

		assertEquals("BDEC", result);
	}

	@Test
	public void checkIfFirstAndLastTwoCharsAreSameBasic() {
		boolean result = helper.checkIfFirstAndLastTwoCharsAreSame("ABAB");
		//assertEquals(true, result);
		//better is boolean check
		assertTrue(result);
	}

	@Test
	public void checkIfFirstAndLastTwoCharsAreSameBasic2() {
		boolean result = helper.checkIfFirstAndLastTwoCharsAreSame("ABCDEAB");
		//assertEquals(true, result);
		assertTrue(result);
	}

	@Test
	public void checkIfFirstAndLastTwoCharsAreSameBasic3() {
		boolean result = helper.checkIfFirstAndLastTwoCharsAreSame("ABCDEBA");
		//assertEquals(false, result);
		assertFalse(result);
	}
	
	@Test
	public void checkIfFirstAndLastTwoCharsAreSameComplex1() {
		boolean result = helper.checkIfFirstAndLastTwoCharsAreSame("AAA");
		//assertEquals(true, result);
		assertTrue(result);
	}
	@Test
	public void checkIfFirstAndLastTwoCharsAreSameComplex2() {
		boolean result = helper.checkIfFirstAndLastTwoCharsAreSame("ABA");
		//assertEquals(false, result);
		assertFalse(result);
	}
	@Test
	public void checkIfFirstAndLastTwoCharsAreSameComplex3() {
		boolean result = helper.checkIfFirstAndLastTwoCharsAreSame("MD");
		//assertEquals(true, result);
		assertTrue(result);
	}
	@Test
	public void checkIfFirstAndLastTwoCharsAreSameComplex4() {
		boolean result = helper.checkIfFirstAndLastTwoCharsAreSame("M");
		//assertEquals(true, result);
		assertFalse(result);
	}
}
