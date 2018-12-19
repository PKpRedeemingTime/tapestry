package com.patrickKilpatrick.dojoOverflow.pages;

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

import com.patrickKilpatrick.dojoOverflow.entities.Question;
import com.patrickKilpatrick.dojoOverflow.entities.Tag;
import com.patrickKilpatrick.dojoOverflow.services.QuestionService;

import java.util.Date;
import java.util.List;

/**
 * Start page of application tapestryQuickstart.
 */
public class Questions {
	@Inject
	private QuestionService questionService;
	@Property
	private List<Question> questions;
	@Property
	private Question question;
	@Property
	private Tag tag;
	
	void setupRender() {
		questions = questionService.findQuestions();
	}
	
}