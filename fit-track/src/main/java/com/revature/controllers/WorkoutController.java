package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Workout;
import com.revature.services.WorkoutService;

@RestController
@RequestMapping("workout")
public class WorkoutController {

	@Autowired
	private WorkoutService ws;
	
	
	@GetMapping
	public List<Workout> findAll(){
		System.out.println("finding all workouts");
		return ws.findAll();
	}
}
