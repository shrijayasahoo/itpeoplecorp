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
	
	@GetMapping("/greeting")
	public String test(){
		
		String abc = employeeService.hello();
		return abc;
		
	}
	
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
			employees = employeeService.searchByAgeGreater(age);
			break;
		case "searchByAgeLesser" :
			employees = employeeService.searchByAgeLesser(age);
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
		
		//List<Employee> employees = employeeService.searchEmployee(criteria, firstName, lastName, age, salary, addressKeyword, bloodGroup);
		return employees;
		
	}
}
