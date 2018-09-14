package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.UserExercise;


@Repository
public interface UserExerciseRepo extends JpaRepository<UserExercise, Integer>{
	
}
