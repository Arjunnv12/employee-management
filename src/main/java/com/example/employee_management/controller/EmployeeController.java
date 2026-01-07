package com.example.employee_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService service;
	public EmployeeController(EmployeeService service) {
		this.service=service;
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	@GetMapping
	public List<Employee>getAllEmployee(){
		return service.getAllEmployee();
	}
	 @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable Long id) {
	        return service.getEmployeeById(id);
	    }

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return "Employee Deleted Sucessfully";
	}
}