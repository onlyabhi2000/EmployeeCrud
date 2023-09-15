package com.abhishek.emsrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.emsrestapi.model.Employee;
import com.abhishek.emsrestapi.service.EmployeeService;

import jakarta.validation.Valid;


@RestController
public class EmployeeController {
	
	@Autowired
	//so the EmployeeService will be injected to this
	private EmployeeService eService;
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		return eService.getEmployees(pageNumber,pageSize);
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public Employee getEmployee( @PathVariable( "id") Long id) {
	
		return eService.getsinleEmployee(id); 
	}
	
	//creating handler method to save employee details
	
	
	@PostMapping("/employees")
	public Employee saveEmployee( @Valid @RequestBody Employee employee) {
		return eService.saveEmployee(employee);
	}
	
	
	//localhost:8080/employees?id=2
	@DeleteMapping("/employees")
	public void deleteEmployee( @RequestParam("id") Long id) {
		eService.deleteEmployee(id);
	}
	
	
	//update employee
	@PutMapping("/employees/{id}")
	public Employee updateEmployee( @PathVariable("id") Long id, @RequestBody  Employee employee) {
		//hv to attach the id 
		employee.setId(id);
		return eService.updateEmployee(employee);
	}
	
	@GetMapping("/employees/filterByName")
	public List<Employee> getEmployeesByName(@RequestParam String name) {
		return eService.getEmployeesByName(name);
	}

//	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
//		return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name) , HttpStatus.OK);
//	}
	
	@GetMapping("/employees/filterByNameAndLocation")
	public List<Employee> getEmployeesByNameAndLocation(@RequestParam String name , @RequestParam String location){
		return eService.getEmployeesByNameAndLocation(name, location);
	}
	
	@GetMapping("/employees/NameKeyword")
	public List<Employee> findByNameKeyword(@RequestParam String name){
		return eService.getEmployeesByKeyword(name);
	}
	
	@GetMapping("/employees/{name}/{location}")
	public List<Employee> getEmployeesByNameOrLocation(@PathVariable String name , @PathVariable String location){
		return eService.getEmployeesByNameOrLocation(name, location);
	}


}
