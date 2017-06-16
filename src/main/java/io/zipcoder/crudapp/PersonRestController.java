package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonRestController {

    @Autowired
    private PersonRepository people;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {//Welcome page, non-rest
        return "There's something here...";
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> findPerson(@PathVariable String id) {//REST Endpoint.
        Person person = people.findOne(Integer.parseInt(id));
        if(person == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Person addPerson(@RequestParam String name, @RequestParam Integer age) {
        return people.save(new Person(name, age));
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deletePerson(@PathVariable Integer id) {
        Person person = people.findOne(id);
        if(person == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        people.delete(id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> modifyPerson(@PathVariable Integer id, @RequestParam String name, @RequestParam Integer age) {
        Person person = people.findOne(id);
        if(person == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        person.setName(name);
        person.setAge(age);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

}
