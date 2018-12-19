package com.patrickKilpatrick.productsAndCategoriesManyToMany.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.productsAndCategoriesManyToMany.entities.Category;
import com.patrickKilpatrick.productsAndCategoriesManyToMany.entities.Product;

public class ProductService {
	@Inject
	private Session session;
	@Property
	private Category category;
	@Property
	private List<Product> products = new ArrayList<Product>();
	@Property
	private List<Product> usedProducts = new ArrayList<Product>();
	@Property
	private List<Product> availableProducts;
	
	@SuppressWarnings("unchecked")
	public List<Product> findProducts() {
		return session.createQuery("select p from Product p order by lower(p.name)").list();
	}
	
	public void createProduct(Product product) {
		product.createdAt = new Date();
		session.persist(product);
	}
	
	public void addCategory(Product product, Category category) {
		product.addCategory(category);
		category.addProduct(product);
		session.persist(product);
		session.persist(category);
	}
	
	public Product findProduct(Long id) {
		return (Product) session.createQuery("select p from Product p where p.id = "+id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAvailableProducts(Long id) {
		availableProducts = new ArrayList<Product>();
		category = (Category) session.createQuery("select c from Category c where c.id = "+id).uniqueResult();
		usedProducts = category.getProducts();
		products = session.createQuery("select p from Product p order by lower(p.name)").list();
		Product test = null;
		for(int i = 0; i < products.size(); i++) {
			for(int y = 0; y < usedProducts.size(); y++) {
				if(usedProducts.get(y) == products.get(i)) {
					test = usedProducts.get(y);
					break;
				}
				test = usedProducts.get(y);
			}
			if(test != products.get(i)) {
				availableProducts.add(products.get(i));
			}
			else {
				continue;
			}
		}
		return availableProducts;
	}
}
