package com.example.demo.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.User;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.repo.UserRepo;

@RestController
@CrossOrigin
@SpringBootApplication

public class Mycontroller {
	@Autowired
	UserRepo userRepo;
	@Autowired
	EmployeeRepo employeeRepo;

	@RequestMapping("userdata/{username}")
	public User Userdata(@PathVariable String username) {

		try {
			return userRepo.findByUsername(username);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("login/{username}/{password}")
	public int login(@PathVariable String username, @PathVariable String password) {
		try {
			if (userRepo.countByUsername(username) != 1)
				return -1;
			User user = userRepo.findByUsername(username);
			if (!password.equals(user.getPassword()))
				return -2;
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@RequestMapping("addNewEmployee/{userId}/{name}/{age}/{emailId}/{address}")
	public Employee AddnewEmployee(@PathVariable int userId, @PathVariable String name, @PathVariable int age,
			@PathVariable String emailId, @PathVariable String address) {
		try {
			if (emailId.equals(employeeRepo.emailidvarify(emailId))) {
				return null;
			} else {
				Employee employees = new Employee(0, name, age, emailId, address);

				employees = employeeRepo.save(employees);
				User user = userRepo.findById(userId).get();
				user.getEmployee().add(employees);
				userRepo.save(user);

				return employees;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@RequestMapping("upadate/{empId}/{userId}/{name}/{age}/{emailId}/{address}")
	public User updateEmployeedata(@PathVariable int empId, @PathVariable int userId, @PathVariable String name,
			@PathVariable int age, @PathVariable String emailId, @PathVariable String address) {
		if (emailId.equals(employeeRepo.emailidvarify(emailId))) {
			return null;
		} else {
			try {
				User user = userRepo.findById(userId).get();
				Employee employees = new Employee(empId, name, age, emailId, address);
				employees = employeeRepo.save(employees);

				return user;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

	}

	@RequestMapping("delete/{id}/{userId}")
	private User deleteEmployee(@PathVariable int id, @PathVariable int userId) {
		try {
			User user = userRepo.findById(userId).get();
			Employee e = employeeRepo.findById(id).get();
			user.getEmployee().remove(e);
			userRepo.save(user);
			employeeRepo.deleteById(id);

			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@RequestMapping("search/{ename}/{userId}")
	private User serrchemailid(@PathVariable String ename, @PathVariable int userId) {
		System.out.println(ename);
		System.out.println(userId);
		try {

			User user = userRepo.findById(userId).get();
			List<Employee> e = employeeRepo.findByEmailId(ename);
			user.setEmployee(e);

			return user;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@RequestMapping("serchlocation/{Aname}/{userId}")
	private User serrchLocation(@PathVariable String Aname, @PathVariable int userId) {
		System.out.println(Aname);
		System.out.println(userId);
		try {

			User user = userRepo.findById(userId).get();
			List<Employee> e = employeeRepo.findByAddress(Aname);

			user.setEmployee(e);

			return user;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
