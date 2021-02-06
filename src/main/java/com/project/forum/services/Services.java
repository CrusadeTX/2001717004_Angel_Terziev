package com.project.forum.services;

import java.util.List;

import com.project.forum.model.Message;
import com.project.forum.model.Topic;
import com.project.forum.model.User;
import com.project.forum.repo.Repository;

public class Services {
	final Repository repo;

	public Services(Repository repo) {
		this.repo = repo;
		
	}
	public String LoginService(String username, String password, String repeatPassword) {
		String result = null;
		boolean matchFound = false;
		if (username == null || password == null || repeatPassword == null) {
			result = "Please enter correct data";
		} else if (!password.equals(repeatPassword)) {
			result = "Please enter matching passwords";
		} else {
			List<User> users = repo.GetAllUsers();
			for(User user : users) {
				if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
					matchFound = true;
				}
			}
			
			result = matchFound ? "User has logged in successfully" : "No such user exists!";
		}
		return result;
		
	}
	
	public void PostMessage(String message, String author) {
		
	}
	public void DeleteMessage(Message message, User user) {
		
	}
	public void DeleteTopic (Topic topic, User user) {
		
	}
	public void CheckMessages (User user) {
		
	}
	

}
