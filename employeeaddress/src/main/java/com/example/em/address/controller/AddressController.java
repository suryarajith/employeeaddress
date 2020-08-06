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
import com.example.em.address.model.Address;
import com.example.em.address.repository.AddressRepository;

@RestController
@RequestMapping("/api")
public class AddressController {
	@Autowired
	private AddressRepository addressRepos;
	
	@PostMapping("/addressadd")
	public Address create(@Validated @RequestBody Address address){
	return addressRepos.save(address);
	}
	
	@GetMapping("/addressget")
	public List<Address>getAllAddressEntity(){
		
	return addressRepos.findAll();
		
	}
	
	@GetMapping("/addressget/{id}")
	public ResponseEntity<Address>getById(@PathVariable(value="id")Long adreId)throws ResourceNotFoundException{ 
	Address add=addressRepos.findById(adreId).orElseThrow(()->new
	ResourceNotFoundException("Address Not Found::"+adreId)); 
	return ResponseEntity.ok().body(add); 
	 }
	
	@DeleteMapping("/addressdele/{id}")
	public Map< String, Boolean >delete( @PathVariable(value = "id") Long aId) throws ResourceNotFoundException {
	Address addressEntity = addressRepos.findById(aId).orElseThrow(()-> new ResourceNotFoundException("Address not found :" +aId));
	addressRepos.delete(addressEntity); 
	Map <String, Boolean > response =new HashMap < >(); 
	response.put("deleted", Boolean.TRUE); 
    return response; 
	  }
	 
	@PutMapping("/addressupdate/{id}")
	public Address update(@PathVariable(value = "id") Long sId,@Valid @RequestBody Address addressup) {

	Address addressR = addressRepos.findById(sId).orElseThrow(() -> new ResourceNotFoundException("Address is not found:"+sId));
	addressR.setAddrLineOne(addressup.getAddrLineOne());
	addressR.setAddLineTwo(addressup.getAddLineTwo());
    addressR.setCity(addressup.getCity());
    Address updatedAddressEntity = addressRepos.save(addressR);
    return updatedAddressEntity; 
		  }

	
	/*@PatchMapping(value="/{id}")
	public @ResponseBody void saveManager(@PathVariable Long aid,@RequestBody Map<Object,Object>fields) {
		Address address=addressRepos.getOne(aid);
		fields.forEach(k,v)->{
			Field field=ReflectionUtils.findField(Address.class,(String) k);
			field.setAccessible(true);
			ReflectionUtils.setField(field, address, v);
		});
		addressRepos.updateAddress(address);
		
	}*/

}
