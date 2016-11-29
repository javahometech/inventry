package in.javahome.inventry;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import in.javahome.inventry.exceptions.InvalidPinException;

public class ATMTest {
	static ATM atm = new ATM();
	static Authenticator authMock;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void setUP() {
		authMock = mock(Authenticator.class);
		atm.auth = authMock;
	}
	
	@AfterClass
	public static void cleanup() {
		System.out.println("AfterClass");
	}
	
	@Test
	public void testWithdraw() {
		when(authMock.authenticate(1111)).thenReturn(true);
		assertEquals(3000, atm.withdraw(1111, 3000));
	}

	@Test
	public void testException() {
		when(authMock.authenticate(5555)).thenReturn(false);
		thrown.expect(InvalidPinException.class);
		assertEquals(3000, atm.withdraw(5555, 3000));
	}
	
	@Test(expected=InvalidPinException.class)
	public void testException2() {
		when(authMock.authenticate(5555)).thenReturn(false);
		assertEquals(3000, atm.withdraw(5555, 3000));
	}

}
