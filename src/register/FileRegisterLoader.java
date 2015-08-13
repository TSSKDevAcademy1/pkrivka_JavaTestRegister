package register;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileRegisterLoader implements Registerable {
	// private Register register;
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static final String FILE = "register.bin";

	// Register register=new
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.DatabaseRegisterLoader#writeRegister(register.Register)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Registerable#writeRegister(register.Register)
	 */
	@Override
	public void writeRegister(Register register) {
		try (FileOutputStream out = new FileOutputStream(FILE); ObjectOutputStream su = new ObjectOutputStream(out)) {
			su.writeObject(register);
		} catch (Exception e) {
			System.err.println("Nepodarilo sa zapisat do suboru.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.DatabaseRegisterLoader#registerLoad()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Registerable#registerLoad()
	 */
	@Override
	public Register registerLoad() {
		Register register = null;
		try (FileInputStream in = new FileInputStream(FILE); ObjectInputStream si = new ObjectInputStream(in)) {
			register = (Register) si.readObject();
			System.out.println("Data zo suboru uspesne nacitane!");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Subor s registrom neexistuje.");
			System.out.println("Vyberte si typ registra pre vytvorenie:\n1) ArrayRegister\n2) ListRegister");
			String typ = readLine();
			if ("1".equals(typ)) {
				register = new ArrayRegister(20);
			} else if ("2".equals(typ)) {
				register = new ListRegister();
			} else {
				System.out.println("Vyber si medzi 1 alebo 2!!!");
			}
		}

		// if (new File(FILE).exists()){
		// FileInputStream in = new FileInputStream(FILE);
		// ObjectInputStream si = new ObjectInputStream(in);
		// register=(Register) si.readObject();
		// si.close();
		// System.out.println("Data uspesne nacitane!");
		// }
		// else {
		// System.out.println("Register neexistuje.");
		// System.out.println("Vyberte si typ registra pre vytvorenie:\n1)
		// ArrayRegister\n2) ListRegister");
		// String typ = readLine();
		// if ("1".equals(typ)) {
		// register = new ArrayRegister(20);
		// } else if ("2".equals(typ)) {
		// register = new ListRegister();
		// } else {
		// System.out.println("Vyber si medzi 1 alebo 2!!!");
		// }
		// }
		return register;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.DatabaseRegisterLoader#registerFill(register.Register)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Registerable#registerFill(register.Register)
	 */
	@Override
	public void registerFill(Register register) {
		register.addPerson(new Person("Janko Hrasko", "0900123456"));
		register.addPerson(new Person("patrik krivka", "0900123715"));
		register.addPerson(new Person("Jozko Mrkvicka", "0908745123"));
		register.addPerson(new Person("Sano Mak", "0905654123"));
	}

}
