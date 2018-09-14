package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Exercise;
import com.revature.services.ExerciseService;

@RestController
@RequestMapping("exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseService es;
	
	@GetMapping
	public List<Exercise> findAll() {
		System.out.println("finding all exercise");
		return es.findAll();
	}
}
