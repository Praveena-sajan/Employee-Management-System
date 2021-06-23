package com.ust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.model.Employee;
import com.ust.repository.EmployeeRepository;

@Service
public class EmployeeSeriveImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeSeriveImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();	 
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();		
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee employee=employeeRepository.findById(id).orElse(null);
		if(employee!=null) {
			employeeRepository.deleteById(id);
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee update= employeeRepository.findById(employee.getId()).orElse(null);
		update=employeeRepository.save(employee);
		if(update==null) {
			return update;
		}
		Employee updated=employeeRepository.findById(update.getId()).get();
		return updated;
		
	}
	

}
