package com.patrickKilpatrick.dojoOverflow.pages;

import org.apache.tapestry5.annotations.InjectPage;

public class Index {
	@InjectPage
	private Questions questions;
	
	Object onActivate() {
		
		return questions;
	}
}
