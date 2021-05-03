package com.example.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.factory.EmployeeInitialiser;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeInitialiser employeeData;

	public List<Employee> searchByBloodGroup(String bloodGroup) {
		List<Employee> employees = (List<Employee>) employeeData.getEmployees().stream()
				  .filter(employee -> bloodGroup.equals(employee.getBloodGroup()))
				  .collect(Collectors.toList());
		return employees;
		
	}

	public List<Employee> searchByAddress(String addressKeyword) {
		List<Employee> employees = employeeData.getEmployees().stream()
				.filter(employee -> employee.getAddress().contains(addressKeyword))
				.collect(Collectors.toList());
		return employees;
		
	}

	public List<Employee> searchBySalary(double salary) {
		List<Employee> employees = employeeData.getEmployees().stream()
				.filter(employee -> salary<employee.getSalary()).collect(Collectors.toList());
		return employees;
		
	}

	public List<Employee> searchByAge(int age, boolean isLesser) {
		List<Employee> employeesWithLessAge = new ArrayList<Employee>();
		List<Employee> employeesWithGreaterAge = new ArrayList<Employee>();
		
		for(Employee employee : employeeData.getEmployees()) {
			Period period = Period.between(employee.getDob(), LocalDate.now());
			if(period.getYears()<age) {
				employeesWithLessAge.add(employee);
			}else if(period.getYears()>age) {
				employeesWithGreaterAge.add(employee);
			}
		}
		if(isLesser) {
			return employeesWithLessAge;
		}else {
			return employeesWithGreaterAge;
		}
		
	}

	public List<Employee> searchByLastName(String lastName) {

		List<Employee> employees = employeeData.getEmployees().stream()
				.filter(employee -> employee.getName().split(" ")[1].equals(lastName)).collect(Collectors.toList());
		return employees;
		
	}

	public List<Employee> searchByFirstName(String firstName) {
		List<Employee> employees = employeeData.getEmployees().stream()
				.filter(employee -> employee.getName().split(" ")[0].equals(firstName)).collect(Collectors.toList());
		return employees;
		
	}

}
