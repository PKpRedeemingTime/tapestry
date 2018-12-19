package com.patrickKilpatrick.dojoOverflow.pages;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.patrickKilpatrick.dojoOverflow.entities.Answer;
import com.patrickKilpatrick.dojoOverflow.entities.Question;
import com.patrickKilpatrick.dojoOverflow.entities.Tag;
import com.patrickKilpatrick.dojoOverflow.services.AnswerService;
import com.patrickKilpatrick.dojoOverflow.services.QuestionService;

public class ShowQuestion {
	@PageActivationContext
	@Property
	private Long questionId;
	@Inject
	private QuestionService questionService;
	@Inject
	private AnswerService answerService;
	@Property
	private Question question;
	@Property
	private Answer answer;
	@Property
	private Tag tag;
	@Property
	private List<Answer> answers;
	@InjectPage
	private ShowQuestion showQuestion;
	
	void setupRender() {
		question = questionService.findQuestion(questionId);
		answers = questionService.findAnswers(question);
	}
	
	Object onSubmit() {
		question = questionService.findQuestion(questionId);
		answerService.createAnswer(answer, question);
		return showQuestion;
	}
}
