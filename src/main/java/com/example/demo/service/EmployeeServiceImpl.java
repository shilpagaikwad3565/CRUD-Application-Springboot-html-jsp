package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl  implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmpbyId(int id) {
		
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}
	
	
	
	
	

}
