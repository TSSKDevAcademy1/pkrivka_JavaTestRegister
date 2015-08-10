package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		Register register = null;
		System.out.println("Vyber si typ registra:\n1) ArrayRegister\n2) ListRegister");
		String typ = readLine();
		if ("1".equals(typ)) {
			register = new ArrayRegister(20);
		} else if ("2".equals(typ)) {
			register = new ListRegister();
		} else {
			System.out.println("Vyber si medzi 1 alebo 2!!!");
		}

		ConsoleUI ui = new ConsoleUI(register);
		ui.run();

		register.addPerson(new Person("Janko Hrasko", "0900123456"));
		register.addPerson(new Person("patrik krivka", "0900123715"));
		register.addPerson(new Person("Jozko Mrkvicka", "0908745123"));
		register.addPerson(new Person("Sano Mak", "0905654123"));
	}

	private static String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}
}
