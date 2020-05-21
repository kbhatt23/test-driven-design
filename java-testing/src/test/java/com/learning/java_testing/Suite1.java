package com.learning.java_testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.learning.java_testing.helper.StringHelperTest;

@RunWith(Suite.class)
@SuiteClasses({StringHelperTest.class, ArrayCompareTest.class})
public class Suite1 {

}
