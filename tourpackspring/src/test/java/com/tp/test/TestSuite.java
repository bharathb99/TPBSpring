package com.tp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { CustomerTest.class, PackagesTest.class})
public class TestSuite {

}
