package com.spring22;


import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;

class StandardTest {

	@BeforeAll
	static void initAll() {
		System.out.println("initAll()");
	
	}
	@BeforeEach
	void init() {
		System.out.println("init()");
	}
	
	@Test
	void succeedingTest() {
		System.out.println("SucceedingTest()");
	}
	
	@Test
	void failingTest() {
		System.out.println("failingTest()");
		
	}
	
	
	@Test
	void abortedTest() {
		System.out.println("abortedTest()");
        assumeTrue("abc".contains("z"));
		fail("test should have been absorted");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("tearDown()");
	}
	
}
