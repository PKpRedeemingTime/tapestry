package com.patrickKilpatrick.productsAndCategoriesManyToMany.pages.categories;

import java.util.List;

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

public class ShowCategory {
	@PageActivationContext
	@Property
	private Long categoryId;
	@Property
	private Category category;
	@Property
	private Product newProduct;
	@Property
	private List<Product> categoryProducts;
	@Property
	private List<Product> availableProducts;
	@Inject 
	private ProductService productService;
	@Inject 
	private CategoryService categoryService;
	@Property
	private SelectModel productsModel;
	@Inject
	private SelectModelFactory selectModelFactory;
	@Inject
	private PageRenderLinkSource pageRenderLS;
	
	void setupRender() {
		category = categoryService.findCategory(categoryId);
		categoryProducts = category.getProducts();
		availableProducts = productService.findAvailableProducts(categoryId);
		productsModel = selectModelFactory.create(availableProducts, "name");
	}
	
	@CommitAfter
	Object onSuccess() {
		category = categoryService.findCategory(categoryId);
		categoryService.addProduct(category, newProduct);
		return pageRenderLS.createPageRenderLinkWithContext("categories/ShowCategory", categoryId);
	}
}
