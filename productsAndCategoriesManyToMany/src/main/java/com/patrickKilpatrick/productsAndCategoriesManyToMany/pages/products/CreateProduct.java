package com.patrickKilpatrick.productsAndCategoriesManyToMany.pages.products;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import com.patrickKilpatrick.productsAndCategoriesManyToMany.entities.Product;
import com.patrickKilpatrick.productsAndCategoriesManyToMany.services.ProductService;

public class CreateProduct {
	@Inject
	private ProductService productService;
	@Property
	private Product product;
	@InjectPage
	private ShowProduct showProduct;
	@Inject
	private PageRenderLinkSource pageRenderLS;
	
	@CommitAfter
	Object onSuccess() {
		productService.createProduct(product);
		String id = product.id.toString();
		return pageRenderLS.createPageRenderLinkWithContext("products/ShowProduct", id);
	}
}
