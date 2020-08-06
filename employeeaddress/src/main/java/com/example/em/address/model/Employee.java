package com.example.em.address.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="employee")

public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3,message="Length minimum 3 characters")
	@Column(name="name")
	private String name;
	
	@Column(name="dateOfBirth")
	private LocalDate dateOfBirth;
	
	@ManyToMany(targetEntity=Address.class, cascade = {CascadeType.MERGE})
		      @JoinTable(name="employee_address",joinColumns =@JoinColumn(name="employee_id"),inverseJoinColumns=@JoinColumn(name="aid"))
		     private Set<Address>address;

	
    public Employee() {
    	
    }


	public Employee(@Size(min = 3, message = "Length minimum 3 characters") String name, LocalDate dateOfBirth,
			Set<Address> address) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
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


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Set<Address> getAddress() {
		return address;
	}


	public void setAddress(Set<Address> address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getAddress()=" + getAddress() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
    
    

	

}
