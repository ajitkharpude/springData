package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.User;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	boolean deleteEmployeeById(int id);

	List<Employee> findByAddress(String name);

	List<Employee> findByEmailId(String emailid);

	@Query(value = "select email_id from employee where email_id=?1", nativeQuery = true)
	String emailidvarify(String emailId);
}
