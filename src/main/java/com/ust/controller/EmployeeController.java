package com.ust.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Employee;
import com.ust.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee createEmp=employeeService.createEmployee(employee);
		if(createEmp==null) {
			return new ResponseEntity<>(createEmp, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Employee>(createEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("/getallEmp")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees=employeeService.getAllEmployees();
		if(employees.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		Employee empbyId=employeeService.getEmployeeById(id);
		if(empbyId==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Employee>(empbyId, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> getEmployeeAfterDeleting(@PathVariable("id")int id,@RequestBody Employee employee)  {
		 Employee deleteEmployee= employeeService.deleteEmployee(id);		
		return new ResponseEntity<Employee>(deleteEmployee,HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updateEmployee= employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(updateEmployee,HttpStatus.OK);
 
	}
	
	 

}
