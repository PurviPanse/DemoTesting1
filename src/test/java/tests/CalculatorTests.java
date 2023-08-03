package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Calculator;

class CalculatorTests {

	@Test
	public void testAdd() {
		int exp = 30;
		Calculator cal = new Calculator();
		int act = cal.add(10, 20);
		assertEquals(exp, act);
		
	}
	@Test
	public void testing() {
		System.out.println("temperority added it");
	}
	
	@Test
	public void testnewB() {
		//code by B
	}

	@Test
	public void testnewA() {
		//code by A
	}
	
}
