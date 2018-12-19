package com.patrickKilpatrick.productsAndCategoriesManyToMany.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.patrickKilpatrick.productsAndCategoriesManyToMany.entities.Category;
import com.patrickKilpatrick.productsAndCategoriesManyToMany.entities.Product;

public class CategoryService {
	@Inject
	private Session session;
	@Property
	private Product product;
	@Property
	private List<Category> categories = new ArrayList<Category>();
	@Property
	private List<Category> usedCategories = new ArrayList<Category>();
	@Property
	private List<Category> availableCategories;
	
	@SuppressWarnings("unchecked")
	public List<Category> findCategories() {
		return session.createQuery("select c from Category c order by lower(c.name)").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAvailableCategories(Long id) {
		availableCategories = new ArrayList<Category>();
		product = (Product) session.createQuery("select p from Product p where p.id = "+id).uniqueResult();
		usedCategories = product.getCategories();
		categories = session.createQuery("select c from Category c order by lower(c.name)").list();
		Category test = null;
		for(int i = 0; i < categories.size(); i++) {
			for(int y = 0; y < usedCategories.size(); y++) {
				if(usedCategories.get(y) == categories.get(i)) {
					test = usedCategories.get(y);
					break;
				}
				test = usedCategories.get(y);
			}
			if(test != categories.get(i)) {
				availableCategories.add(categories.get(i));
			}
			else {
				continue;
			}
		}
		return availableCategories;
	}
	
	public void createCategory(Category category) {
		category.createdAt = new Date();
		session.persist(category);
	}
	
	public void addProduct(Category category, Product product) {
		category.addProduct(product);
		product.addCategory(category);
		session.persist(category);
		session.persist(product);
	}
	
	public Category findCategory(Long id) {
		return (Category) session.createQuery("select c from Category c where c.id = "+id).uniqueResult();
	}
}
