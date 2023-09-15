package com.abhishek.emsrestapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.emsrestapi.model.Employee;


@Repository
public interface EmployeeRepository  extends PagingAndSortingRepository<Employee, Long>{
	
	
	//jpa querymethods or finder methods
	
	List<Employee> findByName(String name);
	
	//jpa query --> when hv to search using two fields
	
	List<Employee> findByNameAndLocation(String name , String location);
	
	//Select * FROM  table WHERE name LIKE "%thor%"
	
	List<Employee> findByNameContaining(String keyword);

	Employee save(Employee employee);

	Optional<Employee> findById(Long id);

	void deleteById(Long id);
	
	
	//JPQL querie
	@Query("FROM Employee WHERE name=:name OR location=:location")
	List<Employee> getEmployeesByNameAndLocation(String name , String location);


	

}
