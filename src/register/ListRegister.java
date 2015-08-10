package register;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListRegister implements Register {
	private List<Person> persons = new ArrayList<>();
	public Iterator<Person> iterator() {
		return persons.iterator();
	}

	/** Number of persons in this register. */

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public Person getPerson(int index) {
		// TODO Auto-generated method stub
		return persons.get(index);
	}

	@Override
	public void addPerson(Person person) {
		persons.add(person);
	}

	@Override
	public Person findPersonByName(String name) {
		Iterator<Person> iterator=persons.iterator();
		while (iterator.hasNext()){
			Person p=iterator.next();
			if (p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}

	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
		Iterator<Person> iterator=persons.iterator();
		while (iterator.hasNext()){
			Person p=iterator.next();
			if (p.getPhoneNumber().equals(phoneNumber)){
				return p;
			}
		}
		return null;
	}

	@Override
	public void removePerson(Person person) {
		persons.remove(person);
	}

}