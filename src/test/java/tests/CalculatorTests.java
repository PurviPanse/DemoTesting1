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
	public void testnewB() {
			System.out.println("new code by B ");
		}
}
