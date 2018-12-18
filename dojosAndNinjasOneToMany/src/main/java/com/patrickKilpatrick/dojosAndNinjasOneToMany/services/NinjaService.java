package com.patrickKilpatrick.dojosAndNinjasOneToMany.services;

import java.util.Date;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.dojosAndNinjasOneToMany.entities.Dojo;
import com.patrickKilpatrick.dojosAndNinjasOneToMany.entities.Ninja;

public class NinjaService {
	@Inject
	private Session session;
	
	public void createNinja(Ninja ninja, Dojo dojo) {
		ninja.createdAt = new Date();
		dojo.addNinja(dojo, ninja);
		ninja.setDojo(dojo);
		session.persist(dojo);
		session.persist(ninja);
	}
}
