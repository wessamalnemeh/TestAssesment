package com.assecor.assessment.test.dao.impl;

import com.assecor.assessment.test.dao.PersonDAO;
import com.assecor.assessment.test.model.Color;
import com.assecor.assessment.test.model.Person;
import com.assecor.assessment.test.service.CSVService;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonCSVDAO implements PersonDAO {



    private List<Person> persons;


    public PersonCSVDAO(CSVService csvService){
        persons=new ArrayList<Person>();
        BufferedReader br=csvService.readData();
        String line = "";
        try{
            int rowNumber = 0;
            while ((line = br.readLine()) != null) {

                String[] row = line.split(",");
                if (row.length == 4) {
                    Person person = new Person();
                    person.setId(++rowNumber);
                    person.setName(row[0].trim());
                    person.setLastname(row[1].trim());

                    String[] addressData = row[2].trim().split(" ");
                    person.setZipcode(addressData[0].trim());
                    person.setCity(addressData[1].trim());
                    person.setColor(Color.findByValue(Integer.parseInt(row[3].trim())));
                    persons.add(person);
                } else {
                    Person person = new Person();
                    person.setId(++rowNumber);
                    person.setName(row[0].trim());
                    person.setLastname(row[1].trim());

                    line = br.readLine();
                    row = line.split(",");
                    String[] addressData = row[0].trim().split(" ");
                    person.setZipcode(addressData[0].trim());
                    person.setCity(addressData[1].trim());
                    person.setColor(Color.findByValue(Integer.parseInt(row[1].trim())));
                    persons.add(person);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Person> getPersons() {

        return persons;
    }

    @Override
    public Person getPersonById(Integer personId) {

        for (Person person : persons) {
            if (person.getId() == personId)
                return person;
        }
        return null;
    }

    @Override
    public List<Person> getPersonsByColor(String color) {
        List<Person> filteredPersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getColor().equals(color))
                filteredPersons.add(person);
        }
        return filteredPersons;
    }

    @Override
    public Person addPerson(Person person) {
        return null;
    }


}
