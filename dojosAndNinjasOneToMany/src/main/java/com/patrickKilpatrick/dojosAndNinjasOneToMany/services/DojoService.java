package com.patrickKilpatrick.dojosAndNinjasOneToMany.services;

import java.util.Date;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.dojosAndNinjasOneToMany.entities.Dojo;

public class DojoService {
	@Inject
	private Session session;
	
	@SuppressWarnings("unchecked")
	public List<Dojo> findDojos() {
		return session.createQuery("select d from Dojo d order by lower(d.name)").list();
	}
	
	public void createDojo(Dojo dojo) {
		dojo.createdAt = new Date();
		session.persist(dojo);
	}
	
	public Dojo findDojo(Long id) {
		return (Dojo) session.createQuery("select d from Dojo d where d.id = "+id).uniqueResult();
	}
}
