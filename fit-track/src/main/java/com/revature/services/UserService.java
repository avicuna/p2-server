package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.projections.BasicUserProjection;
import com.revature.repos.UserRepo;


@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
	

	
	@Autowired 
	public List<User> findAll() {
		return ur.findAll();
	}
	
	public Optional<User> Update(User newUser) {

		Optional<User> oldUser = ur.findById(newUser.getId());
		oldUser.ifPresent(user -> {
			if(newUser.getFirstname() != null) {
				user.setFirstname(newUser.getFirstname());
			}
			if(newUser.getLastname() != null) {
				user.setLastname(newUser.getLastname());
			}
			if(newUser.getEmail() != null) {
				user.setEmail( newUser.getEmail());
			}
			if(newUser.getHeight() != 0) {
				user.setHeight(newUser.getHeight());
			}
			if(newUser.getWeight() != 0) {
				user.setWeight( newUser.getWeight());
			}
			ur.saveAndFlush(user);
		});
			return oldUser;

				
	}
	
	public BasicUserProjection login(String username, String password) {
		return ur.findByUsernameAndPassword(username, password);
	}
	public int save(User u) {
		return ur.saveAndFlush(u).getId();
	}	
}
