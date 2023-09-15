package com.abhishek.emsrestapi.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.abhishek.emsrestapi.model.Employee;



public interface EmployeeService {
	
//	List<Employee> getEmployees1();

	List<Employee> getEmployees(int pageNumber , int pageSize);
	
	//method to save employee records to db
	
	Employee saveEmployee(Employee employee);
	
	//method to get single employee
	
	Employee getsinleEmployee( Long id);
	
	//method to delete the employee
	
	void deleteEmployee(Long id);
	
	//method to update the employee
	
	Employee updateEmployee(Employee employee);
	
	//method to find employee by name
	
	List<Employee> getEmployeesByName(String name);
	
	//method to find by name and location
	
	List<Employee> getEmployeesByNameAndLocation(String name , String location);
	
	//Searching employees using name keyword
	List<Employee> getEmployeesByKeyword(String name);
	
	//sorting
	

	//JPQL query method
	List<Employee> getEmployeesByNameOrLocation(String name , String location);
	


}
