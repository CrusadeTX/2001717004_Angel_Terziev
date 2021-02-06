package com.project.forum.repo;

import java.util.ArrayList;
import java.util.List;

import com.project.forum.model.Message;
import com.project.forum.model.Topic;
import com.project.forum.model.User;

public class Repository {
	private List<User> Users = new ArrayList<User>();
	private List<Message> Messages = new ArrayList<Message>();
	private List<Topic> Topics = new ArrayList<Topic>();

	public Repository() {
		Users.add(new User("username", "password", "role_user"));
		Users.add(new User("admin", "pass", "role_admin"));
		Messages.add(new Message("sample text","username"));
		Messages.add(new Message("sample text2","username"));
		Messages.add(new Message("sample text3","admin"));
		Topics.add(new Topic("This is a sample topic desc",Messages));
	}
	
	public List<User> GetAllUsers() {
		return Users;
		
	}
	
	public List<Message> GetAllMessages(){
		return Messages;
	}
	public List<Topic> GetAllTopics(){
		return Topics;
	}
	
	public boolean RemoveMessage(String messageText) {
		Message message = getMessageByText(messageText);
		if(message!=null) {
			return Messages.remove(message);
		}
		else {
			return false;
		}
		
	}
	public boolean RemoveTopic(String description) {
		Topic topic = getTopicByDescription(description);
				if(topic!=null) {
					return Topics.remove(topic);
				}
				else {
					return false;
				}
		
	}
	public Topic getTopicByDescription(String description) {
		for (Topic topic : Topics) {
			if(topic.getDescription().equals(description)) {
				return topic;
			}
		}
		return null;
		
	}
	public Message getMessageByText(String text) {
		for (Message message : Messages) {
			if(message.getText().equals(text)) {
				return message;
			}
		}
		return null;
		
	}
	public boolean PostMessage(Message message) {
		return Messages.add(message);
	}

}
