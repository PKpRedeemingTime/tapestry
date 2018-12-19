package com.patrickKilpatrick.productsAndCategoriesManyToMany.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual	
	public Long id;
	@Validate("required")
	public String name;
	@Column(updatable = false)
	public Date createdAt;
	@ManyToMany(mappedBy="categories")
	private List<Product> products = new ArrayList<Product>();
	
	public Category() {
		
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
		setProducts(products);
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
