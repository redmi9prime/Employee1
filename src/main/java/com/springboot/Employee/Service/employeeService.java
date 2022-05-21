package com.springboot.Employee.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.springboot.Employee.Entity.employeeEntity;
import com.springboot.Employee.Exception.ResourceNotFoundException;
import com.springboot.Employee.Repository.employeeRepo;

@Component
public class employeeService {

	@Autowired
	private employeeRepo employeerepo;
	
	
	public employeeEntity getById(int id) {
		Optional<employeeEntity> optional=employeerepo.findById(id);
		if(optional.isPresent()) {
			throw new ResourceNotFoundException("Employee already exits in the database");
		}else {
			throw new ResourceNotFoundException("Employee already exits in the database");
		}
		
	}
//	public employeeEntity Check(int id) {
//		
////		Optional<employeeEntity> optional=employeerepo.findById(id);
////		if(optional.isEmpty()) 
////			return optional.orElseThrow(() -> new ResourceNotFoundException("Employee Already Exists in the Database"));
//////		
//////		return null;		
//		return this.employeerepo.findById(id)
//			.orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exists in the database"));
//	}
//	
//	//addemployee
//	public employeeEntity addEmployee(employeeEntity employee) {
//		employeeEntity result=employeerepo.save(employee);
//		return result;
//	}
//	
	
	//sorting in desc
	public List<employeeEntity> getAll(){
		
		List<employeeEntity> list=(List<employeeEntity>) this.employeerepo.findAll();
		Collections.sort(list, (d1,d2) -> Double.compare(d2.getSalary(),d1.getSalary()));
		return list;
		
	}
	
	public employeeEntity update(employeeEntity entity) {
		employeeEntity old=null;
		Optional<employeeEntity> optionaldoctor=employeerepo.findById((int) entity.getId());
		if(optionaldoctor.isPresent()) {
			old=optionaldoctor.get();
			old.setSalary(entity.getSalary());
			employeerepo.save(old);
		}
		else {
			return new employeeEntity();
		}
		return old;
	}
//	//sorting if salary equals
//	public List<employeeEntity> getequal(employeeEntity e1,int salary){
//		
//		
//	
//		List<employeeEntity> list=(List<employeeEntity>) this.employeerepo.findAll();
//		if(salary==e1.getSalary()) {
//			Collections.sort(list, (a1,a2) -> a1.getName().compareTo(a2.getName()));
//		}
//		return list;
//	}
//
//	public List<employeeEntity> getequal(double salary) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
		

	
	

}


