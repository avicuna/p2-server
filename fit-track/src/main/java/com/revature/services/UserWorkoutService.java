package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.UserWorkout;
import com.revature.repos.UserWorkoutRepo;

@Service
public class UserWorkoutService {
	
	@Autowired
	private UserWorkoutRepo uwr;
	
	public List<UserWorkout> findAllWorkouts(int userId) {
		return uwr.findByUserId(userId);
	}
	

}
