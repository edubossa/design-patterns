package br.com.ews.example.tv.design.state;

public class TVStartState implements State {

	@Override
	public void doAction() {
		System.out.println("TV ON");
	}

}
