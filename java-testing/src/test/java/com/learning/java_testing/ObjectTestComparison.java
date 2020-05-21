package com.learning.java_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.learning.java_testing.bean.ComparableBean;

public class ObjectTestComparison {

	@Test
	public void testObjectInstance() {
		App obj1 = new App();
		App obj2 = new App();
		
		//assert equlas uses .equals method
		//since App do not have overriden equals this will fail
		assertNotEquals(obj1, obj2);
		//assertEquals(obj1, obj2);
	}
	@Test
	public void testCustomObject() {
		ComparableBean obj1 = new ComparableBean(108, "sita ram");
		ComparableBean obj2 = new ComparableBean(108, "radhe krishna");
		
		//assertNotEquals(obj1, obj2);
		//even objects are different equals emthod returns tru for both instances
		assertEquals(obj1, obj2);
	}
}
