package com.patrickKilpatrick.addressBook.pages.address;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.addressBook.entities.Address;
import com.patrickKilpatrick.addressBook.pages.Index;

public class CreateAddress {
	@Property
	private Address address;
	@Inject
    private Session session;
 
    @InjectPage
    private Index index;
 
    @CommitAfter
    Object onSuccess()
    {
        session.persist(address);
 
        return index;
    }
}
