package com.spring22;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class ConditionalTests {
	
	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void runOnWindows() {
		System.out.println("This runs on windows");
	}
	
	@Test
	@EnabledOnOs({OS.LINUX})
	public void runOnLinux() {
		System.out.println("This runs on Linux");
	}

    @Test
    @DisabledIf("Math.random() < 0.314159")
    void mightNotBeExecuted() {
            System.out.println("This may or not execute ");
    }

}


