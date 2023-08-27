package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeesServices;

import jakarta.websocket.server.PathParam;

@RestController
public class EmployeeController {
	
	@Autowired
EmployeesServices employeesServices;
	@PostMapping("{add}")
	public Employee add(@RequestBody Employee employee) {
		// TODO Auto-generated method stub
		return employeesServices.add(employee);

	}
	@RequestMapping("read/{empId}")
	private Employee read(@PathVariable int empId) {
		// TODO Auto-generated method stub
return employeesServices.read(empId);
	}
}
