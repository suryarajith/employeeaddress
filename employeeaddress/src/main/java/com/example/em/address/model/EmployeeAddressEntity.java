package com.example.em.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_address_t")

public class EmployeeAddressEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	 @ManyToOne
	 @JoinColumn(name="add_id")
	 private Address adress;
	 
	 @ManyToOne
	 @JoinColumn(name="ed_id")
	 private Employee emplo;

	 @Column(name="addressType")
	 private  String addressType;
	
	 public EmployeeAddressEntity() {
		
	}

	public EmployeeAddressEntity(Address adress, Employee emplo, String addressType) {
		super();
		this.adress = adress;
		this.emplo = emplo;
		this.addressType = addressType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Employee getEmplo() {
		return emplo;
	}

	public void setEmplo(Employee emplo) {
		this.emplo = emplo;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "EmployeeAddressEntity [id=" + id + ", adress=" + adress + ", emplo=" + emplo + ", addressType="
				+ addressType + ", getId()=" + getId() + ", getAdress()=" + getAdress() + ", getEmplo()=" + getEmplo()
				+ ", getAddressType()=" + getAddressType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

	
	
}
