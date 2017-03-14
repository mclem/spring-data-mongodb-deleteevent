package com.mclem;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, CustomId> {
}
