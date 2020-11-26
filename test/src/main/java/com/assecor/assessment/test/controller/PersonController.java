package com.assecor.assessment.test.controller;

import com.assecor.assessment.test.dao.impl.PersonCSVDAO;
import com.assecor.assessment.test.dao.impl.PersonDBDAO;
import com.assecor.assessment.test.model.Person;
import com.assecor.assessment.test.service.PersonSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    @Autowired
    PersonSerivce personSerivce;

    @GetMapping(path = "/", produces = "application/json")
    public List<Person> getPersons() {
        return personSerivce.getPersons();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Person getPersonById(@PathVariable Integer id) {
        return personSerivce.getPersonById(id);
    }

    @GetMapping(path = "/color/{color}", produces = "application/json")
    public List<Person> getPersonsByColor(@PathVariable String color) {

        return personSerivce.getPersonsByColor(color);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Person addPerson(@RequestBody Person person) {
        return personSerivce.addPerson(person);
    }


}
