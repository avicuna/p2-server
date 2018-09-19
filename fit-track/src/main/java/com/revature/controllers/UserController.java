package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	private UserExerciseService ues;
	
	@GetMapping 
	public List<User> findAll() {
		System.out.println("finding all users");
		return us.findAll();
	}
	
	@GetMapping("/{userId}/workouts") 
	public List<UserWorkout> findAllWorkouts(@PathVariable int userId) {
		System.out.println("finding all user's workouts");
		return uws.findUserWorkout(userId);
	}
	
	@PostMapping("/login") 
	public ResponseEntity<BasicUserProjection> login(@RequestBody User u) {
		System.out.println("logging in");
		if(us.login(u.getUsername(), u.getPassword()) == null) {
			ResponseEntity<BasicUserProjection> re = new ResponseEntity<BasicUserProjection>(us.login(u.getUsername(), u.getPassword()), HttpStatus.NOT_FOUND);
			return re;
		}
		ResponseEntity<BasicUserProjection> re = new ResponseEntity<BasicUserProjection>(us.login(u.getUsername(), u.getPassword()), HttpStatus.OK);
		return re;
	}

	@PostMapping
	public int save(@RequestBody User user) {
		return us.save(user);
	}
	
	@PostMapping("/workout/create")
	public int postWorkout(@RequestBody UserWorkout userWorkout) {
		return uws.postWorkout(userWorkout);
	}
	
	@PostMapping("/workout/create/exercises")
	public void postExercises(@RequestBody List<UserExercise> userExercises) {
		ues.postUserExercises(userExercises);
	}
	
		
}
