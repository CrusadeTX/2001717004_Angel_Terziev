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
	 * @param text - message text to be saved
	 * @param author - author of the message
	 * @return string containing the resulting status message of the Message posting process 
	 */
	public String PostMessage(String text, String author) {
		String result = null;
		boolean operationResult = false;
		if(text == null || text.trim().isEmpty() || author == null || author.trim().isEmpty()) {
			return result = "Please enter correct data!";
		}
		if(text.length()<=3 || text.length()>=255) {
			 return result = "Message must be between 3 and 255 characters long!";
		}
		Message message = new Message(text,author);
		operationResult =  repo.PostMessage(message);
		if (operationResult) {
			return result ="Message added successfully";
		}
		else {
			return result = "Something went wrong. Message hasnt been saved!";
		}
		
		
		
	}
	/**Deletes a message object from the local model store
	 * @param message - message object to be deleted
	 * @param user - user initiating the delete procedure
	 * @return string containing the resulting status message of the Message Deleting process 
	 */
	public String DeleteMessage(Message message, User user) {
		String result = null;
		boolean operationResult = false;
		if(message == null || user == null) {
			return result = "Input parameters cant be null!";
		}
		if(!user.getRole().equals("role_user")) {
			return result = "Users cant delete Messages. Admin rights required!";
		}
		operationResult = repo.RemoveMessage(message);
		if(operationResult) {
			return result = "Message has been deleted successfully";
		}
		
		
		return result;
	}
	/**Deletes a topic object from the local model store
	 * @param topic - topic object to be deleted
	 * @param user - user initiating the delete procedure
	 * @return string containing the resulting status message of the Topic Deleting process 
	 */
	public String DeleteTopic (Topic topic, User user) {
		String result = null;
		return result;
	}
	/**Returns all messages belonging to the specified user
	 * @param user
	 * @return string containing the resulting status message of the Message checking process 
	 */
	public String CheckMessages (User user) {
		String result = null;
		return result;
		
	}
	

}
