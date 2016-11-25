package in.javahome.inventry;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthenticatorTest {
	Authenticator auth = new Authenticator();
	@Test
	public void testPin() {
		assertEquals(true, auth.authenticate(1111));
		assertEquals(false, auth.authenticate(5555));
	}

}
