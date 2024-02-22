package com.herbalife.day28springbootapi.com.herbalife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public void createPerson(Person person) {
        personService.createPerson(person);
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }
}
