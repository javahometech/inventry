package in.javahome.inventry;

import java.util.Arrays;
import java.util.List;

public class Authenticator {
	List<Integer> pins = Arrays.asList(1111,2222,3333);
	public boolean authenticate(int pin){
		return pins.contains(pin);
	}
}
