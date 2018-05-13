package telran.persons.dao;

import telran.persons.dto.Person;

public interface IPersonsDao {
	boolean addPerson(Person person);
	Person getPerson(int id);
	boolean updateName(int id, String newName);
	boolean removePerson(int id);
}
