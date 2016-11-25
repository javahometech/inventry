package in.javahome.inventry;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import in.javahome.inventry.exceptions.InvalidPinException;

public class ATMTest {
	ATM atm = new ATM();
	Authenticator authMock = mock(Authenticator.class);

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUP() {
		atm.auth = authMock;
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

}
