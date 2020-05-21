package com.learning.java_testing.helper;

public class StringHelper {

	public String truncateFirstTwoAChars(String input) {
		if(input == null || input.length() == 0) {
			throw new RuntimeException("Invalid input String");
		}
		if(input.length() <=2) {
			return input.replaceAll("A", "");
		}
		
		String firstTwoChars = input.substring(0, 2);
		String lastChars = input.substring(2);
		
		return firstTwoChars.replaceAll("A", "") + lastChars;
	}
	
	public boolean checkIfFirstAndLastTwoCharsAreSame(String input) {
		int length = input.length();
		if(input == null || length == 0) {
			throw new RuntimeException("Invalid input String");
		}
		boolean result=false;
		if(length == 2) {
			result = true;
		}
		else if(length > 2) {
			String firstTwoChars = input.substring(0, 2);
			String lastTwoChars = input.substring(length-2);
			if(firstTwoChars.equals(lastTwoChars)) {
				result=true;
			}
		}
		return result;
	}
	
}
