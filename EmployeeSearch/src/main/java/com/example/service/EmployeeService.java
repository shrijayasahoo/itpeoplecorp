package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.entity.Employee;
import com.example.factory.EmployeeInitialiser;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeInitialiser employeeData;
	
	public String hello() {
		return "hi";
	}
	
	
	public List<Employee> searchEmployee (String criteria, String firstName, String lastName,
										  Integer age,Double salary,String addressKeyword,String bloodGroup){
		
		List<Employee> employees = new ArrayList<Employee>();
		switch(criteria) {
		case "matchFirstName" :
			employees = this.searchByFirstName(firstName);
			break;
		case "matchLastName" :
			employees = this.searchByLastName(lastName);
			break;
		case "ageGreater" :
			employees = this.searchByAgeGreater(age);
			break;
		case "searchByAgeLesser" :
			employees = this.searchByAgeLesser(age);
			break;
		case "salaryLessThan" :
			employees = this.searchBySalary(salary);
			break;
		case "address" :
			employees = this.searchByAddress(addressKeyword);
			break;
		case "bloodGroup" :
			employees = this.searchByBloodGroup(bloodGroup);
			break;
		
		}
		
		
		return employees;	  									  
	}

	public List<Employee> searchByBloodGroup(String bloodGroup) {
		List<Employee> employees = (List<Employee>) employeeData.getEmployees().stream()
				  .filter(employee -> bloodGroup.equals(employee.getBloodGroup()))
				  .collect(Collectors.toList());
		return employees;
		
	}

	public List<Employee> searchByAddress(String addressKeyword) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Employee> searchBySalary(double salary) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Employee> searchByAgeLesser(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> searchByAgeGreater(int age) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Employee> searchByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Employee> searchByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
		
	}

}
