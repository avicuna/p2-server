package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "user_exercise")
public class UserExercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_exercise_id")
	private int id;
	@Column(name = "user_workout_id")
	private int userWorkoutId;
	@Column(name = "exercise_id")
	private int exerciseId;
	private int weight;
	private int reps;
	@Column(name = "sets_")
	private int sets;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "exercise_id", insertable=false, updatable=false)
	private Exercise exercise;
	
	public UserExercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserExercise(int id, int userWorkoutId, int exerciseId, int weight, int reps, int sets, Exercise exercise) {
		super();
		this.id = id;
		this.userWorkoutId = userWorkoutId;
		this.exerciseId = exerciseId;
		this.weight = weight;
		this.reps = reps;
		this.sets = sets;
		this.exercise = exercise;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userWorkoutId
	 */
	public int getUserWorkoutId() {
		return userWorkoutId;
	}

	/**
	 * @param userWorkoutId the userWorkoutId to set
	 */
	public void setUserWorkoutId(int userWorkoutId) {
		this.userWorkoutId = userWorkoutId;
	}

	/**
	 * @return the exerciseId
	 */
	public int getExerciseId() {
		return exerciseId;
	}

	/**
	 * @param exerciseId the exerciseId to set
	 */
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the reps
	 */
	public int getReps() {
		return reps;
	}

	/**
	 * @param reps the reps to set
	 */
	public void setReps(int reps) {
		this.reps = reps;
	}

	/**
	 * @return the sets
	 */
	public int getSets() {
		return sets;
	}

	/**
	 * @param sets the sets to set
	 */
	public void setSets(int sets) {
		this.sets = sets;
	}

	/**
	 * @return the exercise
	 */
	public Exercise getExercise() {
		return exercise;
	}

	/**
	 * @param exercise the exercise to set
	 */
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
		result = prime * result + exerciseId;
		result = prime * result + id;
		result = prime * result + reps;
		result = prime * result + sets;
		result = prime * result + userWorkoutId;
		result = prime * result + weight;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserExercise other = (UserExercise) obj;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
			return false;
		if (exerciseId != other.exerciseId)
			return false;
		if (id != other.id)
			return false;
		if (reps != other.reps)
			return false;
		if (sets != other.sets)
			return false;
		if (userWorkoutId != other.userWorkoutId)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserExercise [id=" + id + ", userWorkoutId=" + userWorkoutId + ", exerciseId=" + exerciseId
				+ ", weight=" + weight + ", reps=" + reps + ", sets=" + sets + ", exercise=" + exercise + "]";
	}

	
}
