package com.ust.service;

import java.util.List;
import java.util.Optional;

import com.ust.model.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);
	
	Employee deleteEmployee(int id);
	
	Employee updateEmployee(Employee employee);
	

}
