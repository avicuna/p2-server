package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.UserExercise;
import com.revature.services.UserExerciseService;
import com.revature.services.UserWorkoutService;

@CrossOrigin
@RestController
@RequestMapping("exercise-list")
public class UserExerciseController {
	
	@Autowired
	private UserExerciseService ues;
	
	@Autowired
	private UserWorkoutService uws;
	
	@GetMapping("")
	public List<UserExercise> findAll() {
		System.out.println("finding all exercise");
		return ues.findAll();
	}
	
	@GetMapping("/workout/{workoutId}")
	public List<UserExercise> findWorkoutExercises(@PathVariable int workoutId) {
		System.out.println("finding user's workout exercises");
		return uws.findWorkoutExercises(workoutId);
	}
}
