package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.UserWorkout;

public interface UserWorkoutRepo extends JpaRepository<UserWorkout, Integer>{
	
	List<UserWorkout> findByUserId(int userId);
	
}
