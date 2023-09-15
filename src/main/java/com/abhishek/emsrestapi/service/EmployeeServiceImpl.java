package com.abhishek.emsrestapi.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.abhishek.emsrestapi.model.Employee;
import com.abhishek.emsrestapi.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository eRepository;
	
//	//creating a list to store below employee details
//	private static List<Employee> list = new ArrayList<>();
	
	// hard coding the list of employees
//	static {
//		
//		Employee e = new Employee();
//		e.setName(" Harry Porter ");
//		e.setAge(24L);
//		e.setLocation("Bangalore");
//		e.setEmail("harry@gmail.com");
//		e.setDepartment("Magic Developer");
//		//adding details to the list 
//		list.add(e);
//		
//		e = new Employee();
//		e.setName(" Goku ");
//		e.setAge(21L);
//		e.setLocation("Bangalore");
//		e.setEmail("goku@gmail.com");
//		e.setDepartment("Power Developer");
//		//adding details to the list 
//		list.add(e);
//	}
	
	@Override
	public List<Employee> getEmployees(int pageNumber , int pageSize){
		org.springframework.data.domain.Pageable pages = PageRequest.of(pageNumber, pageSize , Direction.DESC,"id");
		
		//fetching all the data from db
		return eRepository.findAll(pages).getContent();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		// TODO Auto-generated method stub
		return eRepository.save(employee);
	}

	@Override
	public Employee getsinleEmployee(Long id) {
		Optional<Employee> employee=eRepository.findById(id);
		
		// TODO Auto-generated method stub
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("employee not found with id"+id);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		eRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		//will save the existing id with new records
		return eRepository.save(employee);


	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return eRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		// TODO Auto-generated method stub
		return eRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> getEmployeesByKeyword(String name) {
		// TODO Auto-generated method stub
		return eRepository.findByNameContaining(name);
	}

	@Override
	public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
		
		return eRepository.getEmployeesByNameAndLocation(name, location);
	}











}
