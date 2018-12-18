package com.patrickKilpatrick.dojosAndNinjasOneToMany.pages;

import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.SelectModelFactory;

import com.patrickKilpatrick.dojosAndNinjasOneToMany.entities.Dojo;
import com.patrickKilpatrick.dojosAndNinjasOneToMany.entities.Ninja;
import com.patrickKilpatrick.dojosAndNinjasOneToMany.services.DojoService;
import com.patrickKilpatrick.dojosAndNinjasOneToMany.services.NinjaService;

public class CreateNinja {
	@Inject
	private NinjaService ninjaService;
	@Inject
	private DojoService dojoService;
	@Property
	private Ninja ninja;
	@Property
	private Dojo dojo;
	@Property
	private SelectModel dojosModel;
	@Inject
	private SelectModelFactory selectModelFactory;
	@Inject
	private PageRenderLinkSource pageRenderLS;
	
	void setupRender() {
		List<Dojo> dojos = dojoService.findDojos();
		dojosModel = selectModelFactory.create(dojos, "name");
	}
	
	@CommitAfter
	Object onSuccess() {
		ninjaService.createNinja(ninja, dojo);
		String id = dojo.id.toString();
		return pageRenderLS.createPageRenderLinkWithContext("ShowDojo", id);
	}

}
