package com.assecor.assessment.test.dao;

import com.assecor.assessment.test.model.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> getPersons();

    public Person getPersonById(Integer personId);

    public List<Person> getPersonsByColor(String color);

    public Person addPerson(Person person);
}
