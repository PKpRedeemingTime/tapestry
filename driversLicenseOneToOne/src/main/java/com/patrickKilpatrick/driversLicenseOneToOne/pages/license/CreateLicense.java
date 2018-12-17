package com.patrickKilpatrick.driversLicenseOneToOne.pages.license;

import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.SelectModelFactory;
import org.hibernate.Session;

import com.patrickKilpatrick.driversLicenseOneToOne.entities.License;
import com.patrickKilpatrick.driversLicenseOneToOne.entities.Person;
import com.patrickKilpatrick.driversLicenseOneToOne.services.LicenseService;
import com.patrickKilpatrick.driversLicenseOneToOne.services.PersonFinderService;
import com.patrickKilpatrick.driversLicenseOneToOne.pages.person.ShowPerson;

public class CreateLicense {
	@Property
	private License license;
	@Property
	private Person person;
	@Property
	private Person newPerson;
	@Property
	private SelectModel personsModel;
	@Inject
	SelectModelFactory selectModelFactory;
	@Inject
	private PageRenderLinkSource pageRenderLS;
	
	@Inject
    private PersonFinderService personFinderService;
	@Inject
    private LicenseService licenseService;

    void setupRender() {
        List<Person> persons = personFinderService.findPersons();
        personsModel = selectModelFactory.create(persons, "fullName");
    }
	
	@CommitAfter
    Object onSuccess() {
        licenseService.createLicense(license, newPerson);
        String id = newPerson.id.toString();
		return pageRenderLS.createPageRenderLinkWithContext("person/ShowPerson", id);
    }
}
