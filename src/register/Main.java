package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new ArrayRegister(20);

        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("patrik krivka", "0900123715"));
        register.addPerson(new Person("Jozko Mrkvicka", "0908745123"));
        register.addPerson(new Person("Sano Mak", "0905654123"));

        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
