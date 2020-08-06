package com.example.em.address.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
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
import com.example.em.address.model.Employee;
import com.example.em.address.repository.EmployeeRepository;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
@RequestMapping("/api")

public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepos;
	
	@PostMapping("/employeeadd")
	public Employee create(@Validated @RequestBody Employee employ){
	return employeeRepos.save(employ);
	}
	
	@GetMapping("/employeeget")
	public List<Employee>getAllEmployeeEntity(){
	return employeeRepos.findAll();	
	}
	
	@GetMapping("/employeeget/{id}")
	public ResponseEntity<Employee>getById(@PathVariable(value="id")Long emId)throws ResourceNotFoundException{ 
	Employee add=employeeRepos.findById(emId).orElseThrow(()->new ResourceNotFoundException("Employee Not Found::"+emId)); 
	return ResponseEntity.ok().body(add); 
	 }
	
	@DeleteMapping("/employeedele/{id}")
	public Map< String, Boolean >delete( @PathVariable(value = "id") Long aId) throws ResourceNotFoundException {
	Employee employeeEntity = employeeRepos.findById(aId).orElseThrow(()-> new ResourceNotFoundException("Employee not found :" +aId));
	employeeRepos.delete(employeeEntity); 
	Map <String, Boolean > response =new HashMap < >(); 
	response.put("deleted", Boolean.TRUE); 
    return response; 
	  }
	 
	@PutMapping("/employeeupdate/{id}")
	public Employee update(@PathVariable(value = "id") Long sId,@Valid @RequestBody Employee emplo) {
	Employee employee1 = employeeRepos.findById(sId).orElseThrow(() -> new ResourceNotFoundException("Employee is not found:"+sId));
	employee1.setName(emplo.getName());
	employee1.setDateOfBirth(emplo.getDateOfBirth());
	employee1.setAddress(emplo.getAddress());
	Employee updatedEmployeeEntity =employeeRepos.save(employee1);
    return updatedEmployeeEntity; 
		 

	 }
   @GetMapping(value ="/name")
   public ResponseEntity<List<Employee>>searchforname(@SearchSpec Specification<Employee> specs) {
   return new ResponseEntity<>(employeeRepos.findAll(Specification.where(specs)),HttpStatus.OK);
	  
	  }
	 


}
