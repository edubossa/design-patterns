package br.com.ews.design.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
	
	private List<User> users;
	
	public ChatMediatorImpl() {
		users = new ArrayList<>();
	}
	
	@Override
	public void sendMessage(String msg, User user) {
		for (User u : users) {
			if(u != user) {
				u.receive(msg);
			}
		}	
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}

}
