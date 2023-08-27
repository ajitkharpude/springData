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
	public Employee AddnewEmployee(@PathVariable int userId,@PathVariable String name,@PathVariable int age,@PathVariable String emailId,@PathVariable String address) {
		try {
			Employee employees=new Employee(0, name, age, emailId, address);
			employees=employeeRepo.save(employees);
			User user=userRepo.findById(userId).get();
			user.getEmployee().add(employees);
			userRepo.save(user);
			
			return employees;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		}
	@RequestMapping("delete/{id}/{userId}")
	private User deleteEmployee(@PathVariable int id,@PathVariable int userId) {
		try {
			User user=userRepo.findById(userId).get();
			user.getEmployee();
			List<Employee>list=user.getEmployee();
			for (int i = 0; i < list.size(); i++) {
				Employee e=list.get(i);
				if(id!=e.getId())
					list.add(e);
			}
			User u1=new User(user.getId(), user.getName(), user.getUsername(), user.getPassword(), list) ;
			userRepo.save(u1);
			
			
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}
}
