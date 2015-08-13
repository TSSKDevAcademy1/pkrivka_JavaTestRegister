package register;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class TextFileRegisterLoader implements Registerable {
	// private Register register;
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static final String FILE = "register.bin";
	private static final String TXTFILE = "register.txt";
	

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
		try (PrintWriter out = new PrintWriter(TXTFILE);) {
			for (int i = 0; i < register.getCount(); i++) {
				out.println(register.getPerson(i).getName());
				out.println(register.getPerson(i).getPhoneNumber());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Pri zapisovani nastala chyba: "+e.getMessage());
		}
	}

	/*
	 * @see register.DatabaseRegisterLoader#registerLoad()
	 */
	/*
	 * @see register.Registerable#registerLoad()
	 */
	@Override
	public Register registerLoad() throws Exception {
		String name;
		String phonenumber;
		Register register;
		//
		try (BufferedReader br = new BufferedReader(new FileReader(TXTFILE));) {
			register=new ArrayRegister(20);
			String line;
			while ((line = br.readLine()) != null) {
				name = line.trim();
				phonenumber=br.readLine().trim();
				register.addPerson(new Person(name,phonenumber));
			}
			System.out.println("Data z txt suboru uspesne nacitane!");
			return register;
		}
		catch (FileNotFoundException e) {
			System.out.println("Pri citani nastala chyba: "+e.getMessage());
			try(PrintWriter out = new PrintWriter(TXTFILE);) {
				
			} catch (Exception e2) {
				System.out.println("Pri vytvarani txt suboru nastala chyba: "+e2.getMessage());
			}
			System.out.println("Bol vytvoreny novy txt subor.");
			register = new ArrayRegister(20);
		}
		return null;
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
