package com.patrickKilpatrick.dojosAndNinjasOneToMany.pages;

import java.util.List;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.patrickKilpatrick.dojosAndNinjasOneToMany.entities.Dojo;
import com.patrickKilpatrick.dojosAndNinjasOneToMany.entities.Ninja;
import com.patrickKilpatrick.dojosAndNinjasOneToMany.services.DojoService;

public class ShowDojo {
	@PageActivationContext
	@Property
	private Long dojoId;
	@Property
	private Dojo dojo;
	@Property
	private List<Ninja> ninjas;
	@Inject
	private DojoService dojoService;
	
	void setupRender() {
		dojo = dojoService.findDojo(dojoId);
		ninjas = dojo.getNinjas();
	}
}
