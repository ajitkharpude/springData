package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Employee;


public interface EmployeeRepo  extends JpaRepository<Employee, Integer>{
boolean deleteEmployeeById(int id);
}
