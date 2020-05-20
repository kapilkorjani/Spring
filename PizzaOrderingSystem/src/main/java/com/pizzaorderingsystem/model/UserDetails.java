package com.pizzaorderingsystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserDetails {

	@Id @GeneratedValue
	private int userId;
	private String name;
	private String email;
	private String mobile;
	private String encryptionKey;
	private String password;
	private String type;
	private String address;
	@OneToOne(mappedBy = "customer")
	private Orders customer;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKey() {
		return encryptionKey;
	}
	public void setKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Orders getCustomer() {
		return customer;
	}
	public void setCustomer(Orders customer) {
		this.customer = customer;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEncryptionKey() {
		return encryptionKey;
	}
	
	
	
	
}
