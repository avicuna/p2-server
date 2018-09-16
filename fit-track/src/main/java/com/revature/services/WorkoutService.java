package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Workout;
import com.revature.repos.WorkoutRepo;

@Service
public class WorkoutService {

	@Autowired
	private WorkoutRepo wr;
	
	public List<Workout> findAll() {
		return wr.findAll();
	}
}
