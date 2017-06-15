package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonRestController {

    @Autowired
    PersonRepository people;

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "There's something here...";
    }

    @RequestMapping("/person/{id}")
    public Person message(@PathVariable String id) {//REST Endpoint.
        return people.findOne(Integer.parseInt(id));
    }

}
