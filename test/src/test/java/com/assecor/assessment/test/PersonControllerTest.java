package com.assecor.assessment.test;


import com.assecor.assessment.test.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PersonControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getPersons() throws Exception {
        String uri = "/persons/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Person[] personsList = super.mapFromJson(content, Person[].class);
        assertTrue(personsList.length > 0);
    }

    @Test
    public void getPersonById() throws Exception {
        String uri = "/persons/8";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Person person = super.mapFromJson(content, Person.class);
        assertTrue(person!=null);
    }

    @Test
    public void getPersonByColor() throws Exception {
        String uri = "/persons/color/rot";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Person[] personslist = super.mapFromJson(content, Person[].class);
        assertTrue(personslist.length > 0);
    }


    @Test
    public void addPerson() throws Exception {
        String uri = "/persons/";
        Person person = new Person();
        person.setName("Test name");
        person.setLastname("Test lastname");
        person.setZipcode("12345");
        person.setCity("Berlin");
        person.setColor("rot");
        String inputJson = super.mapToJson(person);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Person addedPerson = super.mapFromJson(content, Person.class);
        assertTrue(addedPerson.getId() > 0);
    }

}
