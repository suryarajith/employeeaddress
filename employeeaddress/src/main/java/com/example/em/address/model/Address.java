package com.example.em.address.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long aid;
	
	@NotNull
	@Size(min=5, message ="Length mimimum 5 characters")
	@Column(name="addrLineOne")
	private String addrLineOne;
	
	@Column(name="addLineTwo")
	private String addLineTwo;
	
	@Column(name="city")
	private String city;
	@ManyToMany(cascade = {
			 CascadeType.MERGE},mappedBy="address")
			 @JsonIgnore
			 private Set<Employee> employee=new HashSet(); 
	
	public Address() {
		
	}

	public Address(@Size(min = 5, message = "Length mimimum 5 characters") String addrLineOne, String addLineTwo,
			String city, Set<Employee> employee) {
		super();
		this.addrLineOne = addrLineOne;
		this.addLineTwo = addLineTwo;
		this.city = city;
		this.employee = employee;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getAddrLineOne() {
		return addrLineOne;
	}

	public void setAddrLineOne(String addrLineOne) {
		this.addrLineOne = addrLineOne;
	}

	public String getAddLineTwo() {
		return addLineTwo;
	}

	public void setAddLineTwo(String addLineTwo) {
		this.addLineTwo = addLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", addrLineOne=" + addrLineOne + ", addLineTwo=" + addLineTwo + ", city=" + city
				+ ", employee=" + employee + ", getAid()=" + getAid() + ", getAddrLineOne()=" + getAddrLineOne()
				+ ", getAddLineTwo()=" + getAddLineTwo() + ", getCity()=" + getCity() + ", getEmployee()="
				+ getEmployee() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

	

}
