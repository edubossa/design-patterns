package br.com.ews.example.tv.design.state;

/**
 * Objeto que mudará seu comportamento com base no seu estado interno.
 */
public class TVContext implements State {

	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public void doAction() {
		state.doAction();
	}

}
