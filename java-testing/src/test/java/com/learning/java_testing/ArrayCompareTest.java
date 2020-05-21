package com.learning.java_testing;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class ArrayCompareTest {

	@Test
	public void testArraySort() {
		int[] numbers = {5,7,3,6,34,1,9};
		int[] expected = {1,3,5,6,7,9,34};
		
		//array equals check for each index one by one
		//if value in anyindex is unequal assertion fails
		//going to failt without sort
		//assertArrayEquals(expected, numbers);
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}
	
	//performace test
	//@Test
	public void performaceTest() {
		int[] numbers = new int[100000000];
		Random random =new Random();
		for(int i=0 ; i< 100000000; i++) {
			numbers[i] = random.nextInt();
		}
		Arrays.parallelSort(numbers);
		//Arrays.sort(numbers);
	}
	
	//performace test
	//after 100 ms it thoros exception and test fails
		@Test(timeout = 100)
		public void performaceTest1() {
			int[] numbers = new int[100000];
			Random random =new Random();
			for(int i=0 ; i< 100000; i++) {
				numbers[i] = random.nextInt();
			}
			Arrays.sort(numbers);
		}
	
	
}
