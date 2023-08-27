package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Task;
import com.example.demo.Entity.User;
import com.example.demo.repo.TaskRepo;
import com.example.demo.repo.UserRepo;

@RestController
@CrossOrigin
@SpringBootApplication
public class Mycontroller {
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	UserRepo userRepo;
	@Autowired
	TaskRepo taskRepo;

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

	@RequestMapping("addTask{userId}and{work}")
	public Task addTask(@PathVariable int userId, @PathVariable String work) {
		try {
			Task task = new Task(0, work, 0);
			task = taskRepo.save(task);
			User user = userRepo.findById(userId).get();
			user.getTasks().add(task);
			userRepo.save(user);
			return task;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("changeStatus{taskId}and{newStatus}")
	public boolean changeStatus(@PathVariable int taskId, @PathVariable int newStatus) {

		try {
			Task task = taskRepo.findById(taskId).get();
			task.setStatus(newStatus);
			taskRepo.save(task);

			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
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
			String token=jwtUtil.generateToken(user);
			System.out.println(token);
			
			
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
}
