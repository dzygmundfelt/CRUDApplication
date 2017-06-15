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
            //create stream of people with a helper method, filter to the one with the desired ID
            //


            //Person person = new Person();
            //return person;
        }
    }
}
