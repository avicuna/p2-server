package com.revature.models;

import java.util.List;

public class FullWorkout {
	private UserWorkout userWorkout;
	private List<UserExercise> exercises;
	public UserWorkout getUserWorkout() {
		return userWorkout;
	}
	public void setUserWorkout(UserWorkout userWorkout) {
		this.userWorkout = userWorkout;
	}
	public List<UserExercise> getExercises() {
		return exercises;
	}
	public void setExercises(List<UserExercise> exercises) {
		this.exercises = exercises;
	}
}
