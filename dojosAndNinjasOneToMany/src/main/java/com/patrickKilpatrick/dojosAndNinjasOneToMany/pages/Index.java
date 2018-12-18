package com.patrickKilpatrick.dojosAndNinjasOneToMany.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.HttpError;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.hibernate.Session;
import org.slf4j.Logger;

import com.patrickKilpatrick.dojosAndNinjasOneToMany.entities.Dojo;
import com.patrickKilpatrick.dojosAndNinjasOneToMany.services.DojoService;

import java.util.Date;
import java.util.List;

/**
 * Start page of application tapestryQuickstart.
 */
public class Index {
	@Inject
	private DojoService dojoService;
	@InjectPage
	private CreateNinja createNinja;
	@Property
	Dojo dojo;
	
	@CommitAfter
	Object onSuccess() {
		dojoService.createDojo(dojo);
		return createNinja;
	}
	
}