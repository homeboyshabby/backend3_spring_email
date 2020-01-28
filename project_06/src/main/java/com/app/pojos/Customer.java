package com.app.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
	private Integer id;
	private Address address;
	private String name,email,password,newpassword;
	private long phoneNumber;
	private Set<Orders> orders = new HashSet<>();
	private Set<OrderDetails> orderDetails = new HashSet<>();
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(Address address, String name, String email, String password, long phoneNumber) {
		super();
		this.address = address;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	public Customer(int id )
	{
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Embedded
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Column(name = "cust_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "cust_email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "cust_password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "cust_phnumber")
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Transient
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	@OneToMany(mappedBy = "custId",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	@OneToMany(mappedBy = "custId",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnore
	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public void setCustAddress(String flatNo, String buildingName, String area, String city)
	{
		this.address.setFlatNo(flatNo);
		this.address.setBuildingName(buildingName);
		this.address.setArea(area);
		this.address.setCity(city);
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", address=" + address + ", name=" + name + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
