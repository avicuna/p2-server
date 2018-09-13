package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.projections.BasicUserProjection;
import com.revature.repos.UserRepo;


@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
	public List<User> findAll() {
		return ur.findAll();
	}
	
	public BasicUserProjection login(String username, String password) {
		return ur.findByUsernameAndPassword(username, password);
	}
	public int save(User u) {
		return ur.saveAndFlush(u).getId();
	}	
}
