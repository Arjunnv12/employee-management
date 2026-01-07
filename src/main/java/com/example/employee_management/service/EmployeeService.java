package com.example.employee_management.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository repository;
	
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
		
	}
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return repository.findAll();
	}
	
	public Employee getEmployeeById(Long id) {
		return repository.findById(id)
				.orElseThrow(()->new RuntimeException("Employee not found with id:"+id));
	}
	public void deleteEmployee(Long id) {
		repository.deleteById(id);
	}
}