package com.example.controller;

import java.util.ArrayList;
import java.util.List;


import com.example.entity.Employee;
import com.example.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/search/{criteria}")
	public List<Employee> searchEmployees(@PathVariable("criteria") String criteria, 
										  @RequestParam(value="firstName",required = false) String firstName,
										  @RequestParam(value="lastName",required = false) String lastName,
										  @RequestParam(value="age",required = false) Integer age,
										  @RequestParam(value="salary",required = false) Double salary,
										  @RequestParam(value="addressKeyword",required = false) String addressKeyword,
										  @RequestParam(value="bloodGroup",required = false) String bloodGroup){
		
		
		List<Employee> employees = new ArrayList<Employee>();
		switch(criteria) {
		case "matchFirstName" :
			employees = employeeService.searchByFirstName(firstName);
			break;
		case "matchLastName" :
			employees = employeeService.searchByLastName(lastName);
			break;
		case "ageGreater" :
			employees = employeeService.searchByAge(age,false);
			break;
		case "searchByAgeLesser" :
			employees = employeeService.searchByAge(age,true);
			break;
		case "salaryLessThan" :
			employees = employeeService.searchBySalary(salary);
			break;
		case "address" :
			employees = employeeService.searchByAddress(addressKeyword);
			break;
		case "bloodGroup" :
			employees = employeeService.searchByBloodGroup(bloodGroup);
			break;
		
		}
		
		return employees;
		
	}
}
