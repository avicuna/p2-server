package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.projections.BasicUserProjection;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@GetMapping
	public List<User> findAll() {
		System.out.println("finding all users");
		return us.findAll();
	}
	
	@PostMapping("/login")
	public BasicUserProjection login(@RequestBody User u) {
		return us.login(u.getUsername(), u.getPassword());

	@PostMapping
	public int save(@RequestBody User user) {
		return us.save(user);
	}
}
