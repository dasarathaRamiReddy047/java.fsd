package com.spring22;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Assertions {
	
	@Test
	public void assertTests() {
	String str = null;
	String str2 = "2";
	
	String a1[] = {"A","B"};
	String a2[] = {"A","B"};
	
	
	assertTrue(4>0);
	assertFalse(5<1);
	assertNull(str);
	
	assertSame(str,str);
	assertNotSame(str,str2);
	
	
	assertEquals(5,5);
	assertNotEquals(5,6);
	
	assertArrayEquals(a1,a2);
	assertThrows(RuntimeException.class,()->{
		throw new RuntimeException();
	});
	
	

	}
}
