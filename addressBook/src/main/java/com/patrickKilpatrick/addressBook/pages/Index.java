package com.patrickKilpatrick.addressBook.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.HttpError;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.hibernate.Session;
import org.slf4j.Logger;

import com.patrickKilpatrick.addressBook.entities.Address;

import java.util.Date;
import java.util.List;

/**
 * Start page of application tapestryQuickstart.
 */
public class Index {
	@Inject
    private Session session;
    public List<Address> getAddresses() {
        return session.createCriteria(Address.class).list();
    }
}