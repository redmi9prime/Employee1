package com.springboot.Employee.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.Employee.Entity.employeeEntity;
import com.springboot.Employee.Exception.ResourceNotFoundException;
import com.springboot.Employee.Service.employeeService;

@RestController
public class employeeController {

	@Autowired
	private employeeService service;
	
	@GetMapping("exception")
	public employeeEntity getsome(int id) throws ResourceNotFoundException{
		return service.getById(id);
	}
//	//exception for particular employee id
//	@GetMapping("employees/{id}")
//	public employeeEntity checkid(@PathVariable("id") int id) {
//		return service.Check(id);
//	}

//	@GetMapping("/employees")
//	public List<employeeEntity> getEmployees(){
//	
//		List<employeeEntity> list = service.getAllEmployee();
//		return list;
//	}
	//add employee
//	@PostMapping("/employees")
//	public employeeEntity addEmployee(@RequestBody employeeEntity employee){
//		employeeEntity entity=service.addEmployee(employee);
//		return entity;
//	}
	
	@GetMapping("/employeesalary")
	public List<employeeEntity> getsalary(){
		
		List<employeeEntity> list=service.getAll();
		return list;
	}
	
//	@GetMapping("update")
//	public employeeEntity compare(employeeEntity entity,employeeEntity entity1) {
//		employeeEntity list;
//		List<employeeEntity> list1;
//		double cmpsalary = entity.getSalary();
//		if(this.getsalary().equals(cmpsalary)) {
//			list=entity.getName().compareTo(entity1.getName());
//		}
//		return list;
//	}
	@PutMapping("employee/update")
	public employeeEntity update(@RequestBody employeeEntity pojo) {
		return service.update(pojo);
	}

}

