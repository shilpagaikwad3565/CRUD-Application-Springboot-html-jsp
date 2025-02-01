package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	 @GetMapping("/form")
	    public String showEmployeeForm(Model model) {
	        model.addAttribute("employee", new Employee()); // Add empty Employee object
	        return "employeeForm"; // Return form page to add employee
	    }
	
	
	    @GetMapping("/getEmployee")
	    public String getEmployees(Model model) {
	        List<Employee> employees = employeeService.getAllEmployees();
	        model.addAttribute("ListEmployees", employees);
	        return "employees"; // Make sure employees.html exists in src/main/resources/templates/
	    }
	    
	    @PostMapping("/addemp")
	    public Employee addemployee(@RequestBody Employee employee)
	    {
	    	return employeeService.addNewEmployee(employee);
	    }
	    
	    // Save the new employee to the database (via form submission)
	    @PostMapping("/save")
	    public String saveEmployee(@ModelAttribute Employee employee) {
	        employeeService.addNewEmployee(employee); // Save the new employee
	        return "redirect:/api/getEmployee"; // Redirect to employee list page
	    }
	    @GetMapping("/form/{id}")
	    public String showEditEmployeeForm(@PathVariable("id") int id, Model model) {
	        Employee employee = employeeService.getEmpbyId(id).orElse(null);
	        if (employee != null) {
	            model.addAttribute("employee", employee); // Populate form with existing employee data
	            return "employeeForm"; // Return to the form for editing
	        }
	        return "redirect:/api/getEmployee"; // Redirect to employee list if not found
	    }
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.ok("Employee deleted successfully!");
	    }

	}
	



