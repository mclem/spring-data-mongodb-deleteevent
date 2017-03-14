package com.mclem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
@Import(MongoTestConfiguration.class)
public class PersonRepositoryTest {

    @Autowired private MongoTemplate mongoTemplate;
    @Autowired private PersonRepository personRepository;

    @Test
    public void test_delete_DeletesTheDocument() {
        Person person = new Person();
        person.setId(new CustomId("testId"));
        person.setName("John");
        mongoTemplate.insert(person);

        List<Person> persons = mongoTemplate.findAll(Person.class);
        assertEquals(1, persons.size());

        personRepository.delete(new CustomId("testId"));

        persons = mongoTemplate.findAll(Person.class);
        assertEquals(0, persons.size());
    }

}
