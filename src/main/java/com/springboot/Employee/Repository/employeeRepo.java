package com.springboot.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Employee.Entity.employeeEntity;

public interface employeeRepo extends JpaRepository<employeeEntity, Integer>{

}
