package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee addNewEmployee(Employee employee);
	public Optional<Employee>getEmpbyId(int id);
	public void deleteEmployee(int id);

}
