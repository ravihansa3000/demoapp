package com.wso2.demoapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", uniqueConstraints = { @UniqueConstraint(columnNames = { "custId" }) })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custId", nullable = false, unique = true, length = 10)
	private String custId;

	@Column(name = "firstName", length = 20, nullable = true)
	private String firstName;

	@Column(name = "lastName", length = 20, nullable = true)
	private String lastName;

	@Column(name = "email", nullable = true)
	private String email;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
