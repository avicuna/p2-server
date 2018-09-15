package com.revature.models;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//	private String date;
	@Column(name="workout_number")
	private int number;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", insertable = false, updatable=false)
	private User user;
	
	@OneToMany(mappedBy = "userWorkout")
	private List<UserExercise> userExercises;

	
	
	public UserWorkout() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserWorkout(int id, int userId, int workoutId, Date sqlDate, int number, User user,
			List<UserExercise> userExercises) {
		super();
		this.id = id;
		this.userId = userId;
		this.workoutId = workoutId;
		this.sqlDate = sqlDate;
		this.number = number;
		this.user = user;
		this.userExercises = userExercises;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getWorkoutId() {
		return workoutId;
	}



	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}



	public java.sql.Date getSqlDate() {
		return sqlDate;
	}



	public void setSqlDate(java.sql.Date sqlDate) {
		this.sqlDate = sqlDate;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<UserExercise> getUserExercises() {
		return userExercises;
	}



	public void setUserExercises(List<UserExercise> userExercises) {
		this.userExercises = userExercises;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result + ((sqlDate == null) ? 0 : sqlDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userExercises == null) ? 0 : userExercises.hashCode());
		result = prime * result + userId;
		result = prime * result + workoutId;
		return result;
	}



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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
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



	@Override
	public String toString() {
		return "UserWorkout [id=" + id + ", userId=" + userId + ", workoutId=" + workoutId + ", sqlDate=" + sqlDate
				+ ", number=" + number + ", user=" + user + ", userExercises=" + userExercises + "]";
	}


	
}