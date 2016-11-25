package in.javahome.inventry;

import in.javahome.inventry.exceptions.InvalidPinException;

public class ATM {
	public Authenticator auth = new Authenticator();

	public long withdraw(int pin, int amount) {
		if (auth.authenticate(pin)) {
			System.out.println("Withdring amount " + amount);
			return amount;
		}

		throw new InvalidPinException("Invalid pin...");

	}
}
