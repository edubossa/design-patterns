package br.com.ews.design.chain;

public class Dollar20Dispenser implements DispenseChain {
	
	private DispenseChain next;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.next = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		
		if (currency.getAmount() >= 20) {
			
			int num = (currency.getAmount() / 20);
			System.out.println("Dispensing "+num+" 20$ note");
			
			int restante = (currency.getAmount() % 20);
			if (restante != 0) this.dispense(new Currency(restante)); 
			
		} else {
			this.next.dispense(currency);
		}
		
	}

}
