package com.project.forum.services;

import java.util.List;

import com.project.forum.model.Message;
import com.project.forum.model.Topic;
import com.project.forum.model.User;
import com.project.forum.repo.Repository;

/**
 * @author Angel
 * Provides core project functions. 
 *
 */
public class Services {
	final Repository repo;
		
	/**Constructor used for initialization of required components
	 * @param repo object used for initialization of the local store
	 */
	public Services(Repository repo) {
		this.repo = repo;
		
	}
	/**
	 *  Logs the user in the system with the supplied username and password.
	 * @param username - user's username
	 * @param password - user's password
	 * @param repeatPassword - password validation 
	 * @return string containing the resulting status message of the log in process 
	 */
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
	
	/** Posts a message under the current user context
	 * @param message - message text to be saved
	 * @param author - author of the message
	 */
	public void PostMessage(String message, String author) {
		
	}
	/**Deletes a message object from the local model store
	 * @param message - message object to be deleted
	 * @param user - user initiating the delete procedure
	 */
	public void DeleteMessage(Message message, User user) {
		
	}
	/**Deletes a topic object from the local model store
	 * @param topic - topic object to be deleted
	 * @param user - user initiating the delete procedure
	 */
	public void DeleteTopic (Topic topic, User user) {
		
	}
	/**Returns all messages belonging to the specified user
	 * @param user
	 */
	public void CheckMessages (User user) {
		
	}
	

}
