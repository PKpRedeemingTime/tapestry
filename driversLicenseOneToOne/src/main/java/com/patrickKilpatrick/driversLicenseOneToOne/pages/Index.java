package com.patrickKilpatrick.driversLicenseOneToOne.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.patrickKilpatrick.driversLicenseOneToOne.entities.Person;
import com.patrickKilpatrick.driversLicenseOneToOne.pages.license.CreateLicense;
import com.patrickKilpatrick.driversLicenseOneToOne.services.PersonFinderService;


/**
 * Start page of application tapestryQuickstart.
 */
public class Index {
	@Property
	private Person person;
	@InjectPage
    private CreateLicense createLicense;
	@Inject
    private PersonFinderService personFinderService;
	
	@CommitAfter
    Object onSuccess()
    {
        personFinderService.createPerson(person);
        return createLicense;
    }
	
}