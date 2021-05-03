package com.example.factory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Employee;

@Component
public class EmployeeInitialiser {
	
	List<Employee> employees ;

	public List<Employee> getEmployees() {
		this.employees=this.getSampleEmployees();
		return employees;
	}

	private List<Employee> getSampleEmployees() {
		this.employees = new ArrayList<Employee>();
		this.employees.add(new Employee("1", "ab1", LocalDate.parse("1956-10-12"),"manager" , 10000, "test1", "O"));
		this.employees.add(new Employee("2", "ab2", LocalDate.parse("1958-10-12"),"seniormanager" , 20000, "test2", "O"));
		this.employees.add(new Employee("3", "ab3", LocalDate.parse("1959-10-12"),"testmanager" , 15000, "test3", "A"));
		this.employees.add(new Employee("4", "ab4", LocalDate.parse("1951-10-12"),"tester" , 1000, "test4", "B"));
		this.employees.add(new Employee("5", "ab5", LocalDate.parse("1955-10-12"),"developer" , 1500, "test5", "AB"));
		
		
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

}
