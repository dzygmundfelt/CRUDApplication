package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Person findPerson(@PathVariable String id) {//REST Endpoint.
        return people.findOne(Integer.parseInt(id));
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public void addPerson(@RequestParam String name, @RequestParam Integer age) {
        people.save(new Person(name, age));
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Integer id) {
        people.delete(id);
    }

}
