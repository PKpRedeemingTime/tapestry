package com.patrickKilpatrick.dojoOverflow.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual	
	public Long id;
	@Validate("required")
	public String question;
	@Column(updatable = false)
	public Date createdAt;
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Answer> answers = new ArrayList<Answer>();
	@ManyToMany
	@JoinTable(
		name = "questions_tags"	,
		joinColumns = { @JoinColumn(name="question_id") },
		inverseJoinColumns = { @JoinColumn(name="tag_id") }
	)
	private List<Tag> tags = new ArrayList<Tag>();
	
	public Question() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void addAnswer(Question question, Answer answer) {
		this.answers.add(answer);
		this.setAnswers(answers);
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getTags() {
		return tags;
	}
	
	public void addTag(Tag tag) {
		this.tags.add(tag);
		setTags(tags);
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public String getTagName(Tag tag) {
		return tag.tag;
	}

}
