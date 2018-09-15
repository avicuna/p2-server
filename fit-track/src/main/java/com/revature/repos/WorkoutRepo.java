package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Workout;

public interface WorkoutRepo extends JpaRepository<Workout, Integer>{

}
