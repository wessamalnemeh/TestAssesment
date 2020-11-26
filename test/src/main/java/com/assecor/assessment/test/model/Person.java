package com.assecor.assessment.test.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    public Person() {

    }


    public Person(int id, String name, String lastname, String zipcode, String city, int color) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.zipcode = zipcode;
        this.city = city;
        this.color = Color.findByValue(color);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String zipcode;
    private String city;
    private Color color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getColor() {
        return color.name();
    }

    public void setColor(String color) {
        this.color = Color.findByLabel(color);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
