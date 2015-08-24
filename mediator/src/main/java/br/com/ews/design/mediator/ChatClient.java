package br.com.ews.design.mediator;

public class ChatClient {
	
	public static void main(String[] args) {
		
		ChatMediator mediator = new ChatMediatorImpl();
		
		User user1 = new UserImpl(mediator, "Eduardo");
		User user2 = new UserImpl(mediator, "Diego");
		User user3 = new UserImpl(mediator, "Juca");
		
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
				
		user1.send("Vamos Almocar"); //envia a msg pra todos do grupo
		
	}
	
	
}
