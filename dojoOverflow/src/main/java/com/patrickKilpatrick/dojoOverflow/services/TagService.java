package com.patrickKilpatrick.dojoOverflow.services;

import java.util.Date;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.dojoOverflow.entities.Tag;

public class TagService {
	@Inject
	private Session session;
	@Property
	private Tag tagByName;

	public Tag findTagByName(String tag) {
		return (Tag) session.createQuery("select t from Tag t where t.tag = '" + tag + "'").uniqueResult();
	}
	
	public Tag findOrCreateTag(String subject) {
		tagByName = findTagByName(subject);
		if(null == tagByName) {
			Tag newTag = new Tag();
			newTag.setTag(subject);
			newTag.createdAt = new Date();
			session.persist(newTag);
			return newTag;
		}
		else {
			return tagByName;
		}
	}
	
}
