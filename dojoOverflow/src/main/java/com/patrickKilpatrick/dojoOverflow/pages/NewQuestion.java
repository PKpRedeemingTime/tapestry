package com.patrickKilpatrick.dojoOverflow.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import com.patrickKilpatrick.dojoOverflow.entities.Question;
import com.patrickKilpatrick.dojoOverflow.entities.Tag;
import com.patrickKilpatrick.dojoOverflow.services.QuestionService;
import com.patrickKilpatrick.dojoOverflow.services.TagService;

public class NewQuestion {
	@Inject
	private QuestionService questionService;
	@Inject
	private TagService tagService;
	@Property
	private Question question;
	@Property
	private Tag newTag;
	@Property
	private String subject;
	@Inject
	private PageRenderLinkSource pageRenderLS;
	
	@CommitAfter
	Object onSuccess() {
		questionService.createQuestion(question);
		if(null != subject) {
			newTag = tagService.findOrCreateTag(subject);
			questionService.addTag(question, newTag);
		}
		String id = question.id.toString();
		return pageRenderLS.createPageRenderLinkWithContext("ShowQuestion", id);
	}
	
}
