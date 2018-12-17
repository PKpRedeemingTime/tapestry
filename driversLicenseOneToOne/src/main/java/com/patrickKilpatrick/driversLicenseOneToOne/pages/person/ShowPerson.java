package com.patrickKilpatrick.driversLicenseOneToOne.pages.person;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.patrickKilpatrick.driversLicenseOneToOne.data.license.State;
import com.patrickKilpatrick.driversLicenseOneToOne.entities.License;
import com.patrickKilpatrick.driversLicenseOneToOne.entities.Person;
import com.patrickKilpatrick.driversLicenseOneToOne.services.PersonFinderService;

public class ShowPerson {
	@PageActivationContext
	@Property
	private Long personId;
	@Property
	private Person newLicensee;
	@Property
	private License personLicense;
	@Property
	private String licenseExpirationDate;
	@Inject
    private PersonFinderService personFinderService;
	SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
	
	void onActivate() {
		
	}
	
	void setupRender() {
        newLicensee = personFinderService.findPerson(personId);
        personLicense = newLicensee.getLicense();
		licenseExpirationDate = format.format(personLicense.getExpirationDate().getTime()); 
    }

}
