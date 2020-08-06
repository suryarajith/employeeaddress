package com.example.em.address.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.em.address.exception.ResourceNotFoundException;
import com.example.em.address.model.EmployeeAddressEntity;
import com.example.em.address.repository.EmployeeAddressRepository;


@RestController
@RequestMapping("/api")
public class EmployeeAddressController {
	@Autowired
	private EmployeeAddressRepository employeeaddressRepo;
	@PostMapping("/employeeadressadd")
	public EmployeeAddressEntity create(@Validated @RequestBody EmployeeAddressEntity employeeAddress){
	return employeeaddressRepo.save(employeeAddress);
	}
	
	@GetMapping("/employeeaddressget")
	public List<EmployeeAddressEntity>getAllEmployeeAddressEntity(){
	return employeeaddressRepo.findAll();	
	}
	
	@GetMapping("/employeeaddressget/{id}")
	public ResponseEntity<EmployeeAddressEntity>getById(@PathVariable(value="id")Long emdId)throws ResourceNotFoundException{ 
	EmployeeAddressEntity add=employeeaddressRepo.findById(emdId).orElseThrow(()->new ResourceNotFoundException("Employee Address Not Found::"+emdId)); 
	return ResponseEntity.ok().body(add); 
	 }
	
	@DeleteMapping("/Employeadressedele/{id}")
	public Map<String, Boolean>delete( @PathVariable(value = "id") Long aId) throws ResourceNotFoundException {
	EmployeeAddressEntity employeeaddress = employeeaddressRepo.findById(aId).orElseThrow(()-> new ResourceNotFoundException("Employee Address not found :" +aId));
	employeeaddressRepo.delete(employeeaddress); 
	Map <String, Boolean > response =new HashMap < >(); 
	response.put("deleted", Boolean.TRUE); 
    return response; 
	  }
	 
	@PutMapping("/employeeadressupdate/{id}")
	public EmployeeAddressEntity update(@PathVariable(value = "id") Long addId,@Valid @RequestBody EmployeeAddressEntity emplo) {
	EmployeeAddressEntity employad = employeeaddressRepo.findById(addId).orElseThrow(() -> new ResourceNotFoundException("Employee Address  is not found:"+addId));
	employad.setAdress(emplo.getAdress());
	employad.setAddressType(emplo.getAddressType());
	employad.setEmplo(emplo.getEmplo());
	EmployeeAddressEntity updatedEmployeeAddressEntity =employeeaddressRepo.save(employad);
    return updatedEmployeeAddressEntity; 
	 }
	
	

	

}
