package com.patrickKilpatrick.productsAndCategoriesManyToMany.pages.categories;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import com.patrickKilpatrick.productsAndCategoriesManyToMany.entities.Category;
import com.patrickKilpatrick.productsAndCategoriesManyToMany.services.CategoryService;

public class CreateCategory {
	@Inject
	private CategoryService categoryService;
	@Property
	private Category category;
	@InjectPage
	private ShowCategory showCategory;
	@Inject
	private PageRenderLinkSource pageRenderLS;
	
	@CommitAfter
	Object onSuccess() {
		categoryService.createCategory(category);
		String id = category.id.toString();
		return pageRenderLS.createPageRenderLinkWithContext("categories/ShowCategory", id);
	}
}
