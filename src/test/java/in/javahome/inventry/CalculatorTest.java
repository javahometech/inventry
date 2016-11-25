package in.javahome.inventry;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator c = new Calculator();

	@Test
	public void testAddMethod() {
		assertEquals(40, c.add(15, 25));
		assertEquals(-10, c.add(15, -25));
		assertEquals(-40, c.add(-15, -25));
		assertNotEquals(-40, c.add(10, 10));
	}
}
