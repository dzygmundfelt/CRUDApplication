package io.zipcoder.crudapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by danzygmund-felt on 6/15/17.
 */
public class PersonRestController {

    @RestController
    public class HelloWorldRestController {

        @RequestMapping("/")
        public String welcome() {//Welcome page, non-rest
            return "There's something here...";
        }

        @RequestMapping("/person/{id}")
        public Person message(@PathVariable String id) {//REST Endpoint.
            //call getPersonById method


            //Person person = new Person();
            //return person;
            return null;
        }
    }
}
