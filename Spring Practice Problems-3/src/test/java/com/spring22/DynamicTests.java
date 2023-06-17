package com.spring22;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.hibernate.action.spi.Executable;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;


class DynamicTests {

@TestFactory
Collection<DynamicTest> dynamicTests(){
	return Arrays.asList( 
			dynamicTest("simple dynamic test",()->assertTrue(true)),
					dynamicTest("My Executable Class",new MyExecutable()),
					dynamicTest("Exception Excutable",()->{throw new Exception();
					}),
					dynamicTest("simple dyamic test-2",()-> assertTrue(true))
					);
}

}

class MyExecutbale implements Executable{
	@Override
	public void execute() throws Throwable{
		System.out.println("Hello world");
	}
}

