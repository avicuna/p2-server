package com.revature.models;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "user_workout", schema="gt")
public class UserWorkout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_workout_id")
	private int id;
	@Column(name="user_id")
	private int userId;
	@Column(name="workout_id")
	private int workoutId;
	@Column(name="date_")
	java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	@Column(name="workout_number")
	private int number;
	
	@OneToMany(mappedBy = "userWorkoutId")
	private List<UserExercise> userExercises;

	
	public UserWorkout() {
		super();
	}


	public UserWorkout(int id, int userId, int workoutId, Date sqlDate, int number, List<UserExercise> userExercises) {
		super();
		this.id = id;
		this.userId = userId;
		this.workoutId = workoutId;
		this.sqlDate = sqlDate;
		this.number = number;
		this.userExercises = userExercises;
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	/**
	 * @return the workoutId
	 */
	public int getWorkoutId() {
		return workoutId;
	}


	/**
	 * @param workoutId the workoutId to set
	 */
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}


	/**
	 * @return the sqlDate
	 */
	public java.sql.Date getSqlDate() {
		return sqlDate;
	}


	/**
	 * @param sqlDate the sqlDate to set
	 */
	public void setSqlDate(java.sql.Date sqlDate) {
		this.sqlDate = sqlDate;
	}


	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}


	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}


	/**
	 * @return the userExercises
	 */
	public List<UserExercise> getUserExercises() {
		return userExercises;
	}


	/**
	 * @param userExercises the userExercises to set
	 */
	public void setUserExercises(List<UserExercise> userExercises) {
		this.userExercises = userExercises;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result + ((sqlDate == null) ? 0 : sqlDate.hashCode());
		result = prime * result + ((userExercises == null) ? 0 : userExercises.hashCode());
		result = prime * result + userId;
		result = prime * result + workoutId;
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
		UserWorkout other = (UserWorkout) obj;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		if (sqlDate == null) {
			if (other.sqlDate != null)
				return false;
		} else if (!sqlDate.equals(other.sqlDate))
			return false;
		if (userExercises == null) {
			if (other.userExercises != null)
				return false;
		} else if (!userExercises.equals(other.userExercises))
			return false;
		if (userId != other.userId)
			return false;
		if (workoutId != other.workoutId)
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserWorkout [id=" + id + ", userId=" + userId + ", workoutId=" + workoutId + ", sqlDate=" + sqlDate
				+ ", number=" + number + ", userExercises=" + userExercises + "]";
	}


}
