package com.example.em.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.em.address.model.Address;



@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
