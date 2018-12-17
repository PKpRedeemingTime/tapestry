package com.patrickKilpatrick.driversLicenseOneToOne.services;

import java.util.Date;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.driversLicenseOneToOne.entities.Person;

public class PersonFinderService {
	@Inject
    private Session session;
	
	
	public Person findPerson(Long id) {
		return (Person) session.createQuery("select p from Person p where p.id = "+id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findPersons() {
		return session.createQuery("select p from Person p where p.id not in (select s from License s) order by lower(p.lastName), lower(p.firstName)").list();
	}
	
	public void createPerson(Person person) {
		person.createdAt = new Date();
        person.setFullName(person.firstName, person.lastName);
		session.persist(person);
	}
}
