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

import com.revature.models.FullWorkout;
import com.revature.models.User;
import com.revature.models.UserExercise;
import com.revature.models.UserWorkout;
import com.revature.projections.BasicUserProjection;
import com.revature.services.UserExerciseService;
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
	
	@Autowired
	private UserWorkoutService workoutService;
	
	@Autowired
	private UserExerciseService ues;
	
	@GetMapping 
	public List<User> findAll() {
		System.out.println("finding all users");
		return us.findAll();
	}
	
	@GetMapping("/workout/{workoutId}")
	public List<UserExercise> findWorkoutExercises(@PathVariable int workoutId) {
		System.out.println("finding user's workout exercises");
		return uws.findWorkoutExercises(workoutId);
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
	
	@PostMapping("/createworkout")
	public int postWorkout(@RequestBody FullWorkout fullWorkout) {
		int id = workoutService.postWorkout(fullWorkout.getUserWorkout());
		for (UserExercise exercise: fullWorkout.getExercises() ) {
			exercise.setUserWorkoutId(id);
		}
		ues.postUserExercises(fullWorkout.getExercises());
		return id;
	}
	
}
