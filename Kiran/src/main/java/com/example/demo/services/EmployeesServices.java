package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeesDao;
import com.example.demo.entity.Employee;

@Service
public class EmployeesServices {
	@Autowired
EmployeesDao employeesDao;

	public Employee add(Employee employee) {
		// TODO Auto-generated method stub
return employeesDao.save(employee);
	}

	public Employee read(int empId) {
		// TODO Auto-generated method stub
		return employeesDao.findById(empId).get();
	}
}
