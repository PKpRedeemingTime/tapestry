package com.patrickKilpatrick.tapestryQuickstart.pages;

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
import org.slf4j.Logger;

import java.util.Date;
import java.util.Random;

/**
 * Start page of application tapestryQuickstart.
 */
public class Index
{
	
	private final Random random = new Random(System.nanoTime());
	
	@InjectPage
	private Guess guess;
	
	@Log
	Object onActionFromStart() {
		int target = random.nextInt(10) + 1;
		guess.setup(target);
		return guess;
    }
	
}