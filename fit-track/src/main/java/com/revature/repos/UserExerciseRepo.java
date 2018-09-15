package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.UserExercise;


@Repository
public interface UserExerciseRepo extends JpaRepository<UserExercise, Integer>{
	
	List<UserExercise> findByUserWorkoutId(int workoutId);

	
}
