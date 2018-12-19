package com.patrickKilpatrick.productsAndCategoriesManyToMany.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual	
	public Long id;
	@Validate("required")
	public String name;
	@Validate("required")
	public String description;
	@Validate("required")
	public double price;
	@Column(updatable = false)
	public Date createdAt;
	@ManyToMany
	@JoinTable(
		name = "products_categories"	,
		joinColumns = { @JoinColumn(name="product_id") },
		inverseJoinColumns = { @JoinColumn(name="category_id") }
	)
	private List<Category> categories = new ArrayList<Category>();
	
	public Product() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
		setCategories(categories);
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
