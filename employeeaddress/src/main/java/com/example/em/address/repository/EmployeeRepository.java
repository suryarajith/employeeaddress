package com.example.em.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.em.address.model.Employee;

@RepositoryRestResource

public interface EmployeeRepository extends JpaRepository<Employee,Long>,JpaSpecificationExecutor<Employee>{

}
