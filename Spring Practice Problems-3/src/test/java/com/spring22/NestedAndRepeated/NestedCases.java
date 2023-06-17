package com.spring22;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestedCases {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Before all test methods");
	}

	
	@BeforeEach
	static void beforeEach() {
		System.out.println("Before each test method");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("After each test method");
	}
	
	
	@AfterAll
	static void afterAll() {
		System.out.println("After all test methods");
	}
	
	
	@Nested
	@DisplayName("Tests for the method A")
	class A{
		@BeforeEach
		void beforeEach() {
			System.out.println("Before each test method of the A class");
		}
		
		@AfterEach
		void AfterEach() {
			System.out.println("After each test method of the A class");
		}
		
		
	@Test
	void sampleTestForMethod() {
		System.out.println("test for method A");
	}
		
	@Nested
	@DisplayName("When X is true")
	class WhenX{
		
		@BeforeEach
		void beforeEach() {
			System.out.println("Before each test method of the whenX class");
		}
		
		@Test
		void testmethodWhenx() {
			System.out.println("test for method A when x is true");
			
		}
	}
		
	}
}
