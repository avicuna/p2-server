package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Exercise;


@Repository
public interface ExerciseRepo extends JpaRepository<Exercise, Integer>{
	
}
