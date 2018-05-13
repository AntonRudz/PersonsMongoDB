package telran.persons.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import telran.persons.crud.PersonCrud;
@Repository
public interface PersonsMongoRepository extends MongoRepository<PersonCrud, Integer> {

}
