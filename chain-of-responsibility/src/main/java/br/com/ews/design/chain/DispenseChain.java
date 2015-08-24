package br.com.ews.design.chain;

public interface DispenseChain {
	
	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency currency);
	
}
