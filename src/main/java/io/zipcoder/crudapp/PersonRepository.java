package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;


interface PersonRepository extends CrudRepository<Person, Integer> {

}
