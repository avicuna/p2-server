package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Exercise;
import com.revature.repos.ExerciseRepo;


@Service
public class ExerciseService {
	
	@Autowired
	private ExerciseRepo er;
	
	public List<Exercise> findAll() {
		return er.findAll();
	}
}
