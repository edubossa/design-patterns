package br.com.ews.example.tv.design.state;

public class TVStopState implements State {

	@Override
	public void doAction() {
		System.out.println("TV OFF");
	}

}
