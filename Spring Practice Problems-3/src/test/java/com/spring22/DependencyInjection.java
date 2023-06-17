package com.spring22;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class DependencyInjection {
	
	DependencyInjection(TestInfo testinfo) {
		assertEquals("Junit 5 Dependency injection", testinfo.getDisplayName());
	}
	
	@BeforeEach
	void init(TestInfo testInfo) {
		String displayName = testInfo.getDisplayName();
		assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()")); 
	}

	
	@Test
	@Tag("my-tag")
	void test1(TestInfo testInfo) {
		assertEquals("Test 1",testInfo.getDisplayName());
		assertTrue(testInfo.getTags().contains("my-tag"));
	}
	
	@Test
	void test2() {
		
	}

}
