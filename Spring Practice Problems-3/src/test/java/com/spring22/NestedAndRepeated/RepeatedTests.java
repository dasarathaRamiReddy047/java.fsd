package com.spring22;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.spring22.authentication.Calculator;

class RepeatedTests {
	@BeforeAll
	public static void init() {
		System.out.println("Before All init method called");
	}
	
	@BeforeEach
	public void initEach() {
		System.out.println("Before Each initEach() called");
	}
	
	@Test
	@RepeatedTest(5)
	void addNumber(TestInfo testInfo) {
		Calculator c  = new Calculator();
		
	}
		@AfterEach
		public void cleanUpEach() {
			System.out.println("After Each CleanUpEach method called");
		}
		
		@AfterAll
		public static void cleanUp() {
			System.out.println("After All CleanUp() method calles");
		}
	}

