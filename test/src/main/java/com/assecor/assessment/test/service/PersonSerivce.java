package com.assecor.assessment.test.service;

import com.assecor.assessment.test.dao.impl.PersonCSVDAO;
import com.assecor.assessment.test.dao.impl.PersonDBDAO;
import com.assecor.assessment.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonSerivce {

    @Autowired
    private PersonCSVDAO personCSVDao;

    @Autowired
    private PersonDBDAO personDBDAO;

    /**
     * This method is used to fetch all persons from two different data sources (CSV, DB).
     * @return List<Person> This returns a list of all persons found in the data sources.
     */
    public List<Person> getPersons() {
        List<Person> twoSourcesList = new ArrayList<>();
        twoSourcesList.addAll(personDBDAO.getPersons());
        twoSourcesList.addAll(personCSVDao.getPersons());
        return twoSourcesList;
    }

    /**
     * This method is used to get a person from CSV data source.
     * @param id this refers for person id
     * @return Person This returns one person object.
     */
    public Person getPersonById(@PathVariable Integer id) {

        return personCSVDao.getPersonById(id);
    }

    /**
     * This method is used to get persons by favourite color from two different data sources (CSV, DB).
     * @param color this refers for color label ex: rot
     * @return List<Person> This returns a list of persons found in the data sources.
     */
    public List<Person> getPersonsByColor(@PathVariable String color) {
        List<Person> twoSourcesList = new ArrayList<>();
        twoSourcesList.addAll(personDBDAO.getPersonsByColor(color));
        twoSourcesList.addAll(personCSVDao.getPersonsByColor(color));
        return twoSourcesList;
    }

    /**
     * This method is used to add a new person to the DB data source.
     * @param person this refers for person object
     * @return Person This returns the inserted person .
     */

    public Person addPerson(@RequestBody Person person) {
        return personDBDAO.addPerson(person);
    }
}
