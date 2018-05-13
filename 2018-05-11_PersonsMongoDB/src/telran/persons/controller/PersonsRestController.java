package telran.persons.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.persons.dao.IPersonsDao;
import telran.persons.dto.Person;
import telran.persons.dto.PersonsApiConstsnts;
import telran.persons.dto.UpdateName;

@SpringBootApplication
@ComponentScan(basePackages="telran.persons.dao")
@EnableMongoRepositories("telran.persons.mongo.repo")
@RestController
public class PersonsRestController {
@Autowired
	IPersonsDao persons;
@GetMapping("/")
String onlyForTest() {
	persons.addPerson(new Person(123, "Vasia", LocalDate.of(1990, 4, 23)));
	return "ok";
}
@PostMapping(value=PersonsApiConstsnts.ADD_PERSON)
Boolean addPerson(@RequestBody Person person) {
	return persons.addPerson(person);
}
@GetMapping(value=PersonsApiConstsnts.GET_PERSON)
Person getPerson(String id) {
	int idPerson=Integer.parseInt(id);
	return persons.getPerson(idPerson);
}
@PostMapping(value=PersonsApiConstsnts.UPDATE_NAME)
boolean updatePerson(@RequestBody UpdateName update) {
	return persons.updateName(update.getId(),update.getNewName());
}
@PostMapping(value=PersonsApiConstsnts.REMOVE_PERSON)
boolean removePerson(String id) {
	int idPerson=Integer.parseInt(id);
	return persons.removePerson(idPerson);
}
	public static void main(String[] args) {
		SpringApplication.run(PersonsRestController.class, args);
		
	}

}
