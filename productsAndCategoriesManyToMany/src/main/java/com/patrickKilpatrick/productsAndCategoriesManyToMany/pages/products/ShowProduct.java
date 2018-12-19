package com.patrickKilpatrick.productsAndCategoriesManyToMany.pages.products;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.SelectModelFactory;

import com.patrickKilpatrick.productsAndCategoriesManyToMany.entities.Category;
import com.patrickKilpatrick.productsAndCategoriesManyToMany.entities.Product;
import com.patrickKilpatrick.productsAndCategoriesManyToMany.services.CategoryService;
import com.patrickKilpatrick.productsAndCategoriesManyToMany.services.ProductService;

public class ShowProduct {
	@PageActivationContext
	@Property
	private Long productId;
	@Property
	private Product product;
	@Property
	private Category newCategory;
	@Property
	private List<Category> productCategories;
	@Property
	private List<Category> availableCategories;
	@Inject 
	private ProductService productService;
	@Inject 
	private CategoryService categoryService;
	@Property
	private SelectModel categoriesModel;
	@Inject
	private SelectModelFactory selectModelFactory;
	@Inject
	private PageRenderLinkSource pageRenderLS;
	
	void setupRender() {
		product = productService.findProduct(productId);
		productCategories = product.getCategories();
		availableCategories = categoryService.findAvailableCategories(product.id);
		categoriesModel = selectModelFactory.create(availableCategories, "name");
	}
	
	@CommitAfter
	Object onSuccess() {
		product = productService.findProduct(productId);
		productService.addCategory(product, newCategory);
		return pageRenderLS.createPageRenderLinkWithContext("products/ShowProduct", productId);
	}
}
