package br.com.ews.design.chain;

public class Dollar10Dispenser implements  DispenseChain {
	
	private DispenseChain next;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.next = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		
		if (currency.getAmount() >= 10) {
			
			int num = (currency.getAmount() / 10);
			System.out.println("Dispensing "+num+" 10$ note");
			
			int restante = (currency.getAmount() % 10);
			if (restante != 0) this.next.dispense(new Currency(restante));
			
		} else {
			this.next.dispense(currency);
		}
		
	}

}
