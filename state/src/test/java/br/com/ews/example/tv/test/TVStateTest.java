package br.com.ews.example.tv.test;

import org.junit.Test;

import br.com.ews.example.tv.design.state.State;
import br.com.ews.example.tv.design.state.TVContext;
import br.com.ews.example.tv.design.state.TVStartState;
import br.com.ews.example.tv.design.state.TVStopState;

public class TVStateTest {

	@Test
	public void testTVStartState() {		
		TVContext context = new TVContext();
		State start = new TVStartState();
		context.setState(start);
		context.doAction();
	}
	
	
	@Test
	public void testTVStopState() {
		TVContext context = new TVContext();
		State stop = new TVStopState();
		context.setState(stop);
		context.doAction();
	}

}
