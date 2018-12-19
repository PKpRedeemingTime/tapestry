package com.patrickKilpatrick.dojoOverflow.services;

import java.util.Date;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.dojoOverflow.entities.Answer;
import com.patrickKilpatrick.dojoOverflow.entities.Question;
import com.patrickKilpatrick.dojoOverflow.entities.Tag;

public class QuestionService {
	@Inject
	private Session session;
	
	@SuppressWarnings("unchecked")
	public List<Question> findQuestions() {
		return session.createQuery("select q from Question q").list();
	}
	
	public void createQuestion(Question question) {
		question.createdAt = new Date();
		session.persist(question);
	}
	
	public Question findQuestion(Long id) {
		return (Question) session.createQuery("select q from Question q where q.id = "+id).uniqueResult();
	}
	
	public void addTag(Question question, Tag tag) {
		question.addTag(tag);
		tag.addQuestion(question);
		session.persist(question);
		session.persist(tag);
	}
	
	public List<Answer> findAnswers(Question question) {
		return question.getAnswers();
	}
	
}
