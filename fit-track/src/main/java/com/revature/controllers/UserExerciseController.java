package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.UserExercise;
import com.revature.services.UserExerciseService;

@CrossOrigin
@RestController
@RequestMapping("user-exercise")
public class UserExerciseController {
	
	@Autowired
	private UserExerciseService ues;
	
	@GetMapping
	public List<UserExercise> findAll() {
		System.out.println("finding all exercise");
		return ues.findAll();
	}
}
