package com.learning.java_testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAfterTest {

	// only once per class
	// has to be static so can not ue instance methods and variables
	// can be used to create connection pool
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Executing afterClass");
	}

	// before every test call
	@Before
	public void setup() {
		System.out.println("Executing Before");
	}

	// all @test methods are executed in test
	// all such methods has to be public and void
	@Test
	public void testCase1() {
		System.out.println("executing test case1");
	}

	@Test
	public void testCase2() {
		System.out.println("executing test case2");
	}

	@Test
	public void testCase3() {
		System.out.println("executing test case3");
	}

	// after every test call
	@After
	public void cleanup() {
		System.out.println("Executing Cleanup");
	}

	// only once per class
	// can be used to remove connection pool
	@AfterClass
	public static void afterClass() {
		System.out.println("Executing afterClass");
	}

}
