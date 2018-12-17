package com.patrickKilpatrick.driversLicenseOneToOne.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual	
	public Long id;
	@Validate("required")
	public String firstName;
	@Validate("required")
	public String lastName;
	public String fullName;
	@Column(updatable = false)
	public Date createdAt;
	@OneToOne(mappedBy="person", fetch=FetchType.EAGER)
	private License license;
	
	public Person() {
		
	}
	
	public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String firstName, String lastName) {
		String temp = this.firstName + " " + this.lastName;
		this.fullName = temp;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}
	
}
