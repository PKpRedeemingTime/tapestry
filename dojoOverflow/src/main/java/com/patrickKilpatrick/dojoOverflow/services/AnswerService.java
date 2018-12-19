package com.patrickKilpatrick.dojoOverflow.services;

import java.util.Date;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.dojoOverflow.entities.Answer;
import com.patrickKilpatrick.dojoOverflow.entities.Question;

public class AnswerService {
	@Inject
	private Session session;
	
	public void createAnswer(Answer answer, Question question) {
		answer.createdAt = new Date();
		question.addAnswer(question, answer);
		answer.setQuestion(question);
		session.persist(answer);
		session.persist(question);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("Got to the end of createAnswer");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
}
