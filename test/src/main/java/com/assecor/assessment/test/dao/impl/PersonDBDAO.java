package com.assecor.assessment.test.dao.impl;

import com.assecor.assessment.test.dao.PersonDAO;
import com.assecor.assessment.test.model.Color;
import com.assecor.assessment.test.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonDBDAO implements PersonDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Person> getPersons() {
        return this.sessionFactory.getCurrentSession().createQuery("From Person").list();
    }

    @Override
    public Person getPersonById(Integer personId) {
         List<Person>resultList=this.sessionFactory.getCurrentSession().createQuery("From Person p where p.id="+personId).getResultList();
         if(resultList!=null&&resultList.size()>=1)
             return resultList.get(0);
         else
             return null;
    }

    @Override
    public List<Person> getPersonsByColor(String color) {

        return this.sessionFactory.getCurrentSession().createQuery("From Person p where p.color="+Color.findByLabel(color).value).getResultList();

    }

    @Override
    public Person addPerson(Person person) {
        Transaction tx = this.sessionFactory.getCurrentSession().beginTransaction();
        this.sessionFactory.getCurrentSession().save(person);
        tx.commit();
        return person;
    }
}
