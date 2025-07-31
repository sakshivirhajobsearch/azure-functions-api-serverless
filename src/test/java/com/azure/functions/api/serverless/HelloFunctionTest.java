package com.azure.functions.api.serverless;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloFunctionTest {

	@Test
	public void testResponse() {
		HelloFunction function = new HelloFunction();
		String response = "Hello, Anurag!";

		assertEquals("Hello, Anurag!", response);
	}
}
