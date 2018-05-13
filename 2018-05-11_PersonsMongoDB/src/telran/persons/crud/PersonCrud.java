package telran.persons.crud;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import telran.persons.dto.Person;
@Document(collection="persons")
public class PersonCrud {
	@Id
private int id;
private String name;
private LocalDate birthdate;
public Person getPerson() {
	Person res=new Person(id, name, birthdate);
	return res;
}

public void setName(String name) {
	this.name = name;
}

public PersonCrud(Person person) {
	id=person.getId();
	name=person.getName();
	birthdate=person.getBirthdate();
}
public PersonCrud() {
	
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public LocalDate getBirthdate() {
	return birthdate;
}

}
