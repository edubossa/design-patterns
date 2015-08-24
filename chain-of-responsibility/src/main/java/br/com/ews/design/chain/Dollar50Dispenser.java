package br.com.ews.design.chain;

public class Dollar50Dispenser implements DispenseChain {
	
	private DispenseChain next;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.next = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		if (currency.getAmount() >= 50) 
		{
			int num = (currency.getAmount() / 50);
			System.out.println("Dispensing "+num+" 50$ note");
            
			int restante = (currency.getAmount() % 50);
            if(restante != 0) this.next.dispense(new Currency(restante));
		} 
		else 
		{
			this.next.dispense(currency);
		}
	}

}
