package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.models.UserWorkout;
import com.revature.projections.BasicUserProjection;
import com.revature.services.UserService;
import com.revature.services.UserWorkoutService;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserWorkoutService uws;
	
	
	@GetMapping 
	public List<User> findAll() {
		System.out.println("finding all users");
		return us.findAll();
	}
	
	@GetMapping("/workouts/{userId}") 
	public List<UserWorkout> findAllWorkouts(@PathVariable int userId) {
		System.out.println("finding all user's workouts");
		return uws.findAllWorkouts(userId);
	}
	
	@PostMapping("/login") 
	public BasicUserProjection login(@RequestBody User u) {
		return us.login(u.getUsername(), u.getPassword());
	}

	@PostMapping
	public int save(@RequestBody User user) {
		return us.save(user);
	}
	
}
