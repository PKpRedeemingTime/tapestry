package com.patrickKilpatrick.driversLicenseOneToOne.services;

import java.util.Date;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.driversLicenseOneToOne.entities.License;
import com.patrickKilpatrick.driversLicenseOneToOne.entities.Person;

public class LicenseService {
	@Inject
    private Session session;
	@Inject
    private PersonFinderService personFinderService;
	@Property
	private Person newPerson;
	
	public void createLicense(License license, Person person) {
		license.createdAt = new Date();
		license.number = String.format("%06d", person.id);
		Person joinPerson = personFinderService.findPerson(person.id);
		joinPerson.setLicense(license);
		license.setPerson(joinPerson);
		session.persist(joinPerson);
        session.persist(license);
	}

}
