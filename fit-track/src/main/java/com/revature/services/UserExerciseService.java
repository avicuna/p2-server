package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.UserExercise;
import com.revature.repos.UserExerciseRepo;


@Service
public class UserExerciseService {
	
	@Autowired
	private UserExerciseRepo uer;
	
	public List<UserExercise> findAll() {
		return uer.findAll();
	}
}
