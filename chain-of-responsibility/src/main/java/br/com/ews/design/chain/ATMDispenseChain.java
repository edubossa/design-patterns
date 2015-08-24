package br.com.ews.design.chain;

import java.util.Scanner;

public class ATMDispenseChain {
	
	private DispenseChain chainDollar50;

	public ATMDispenseChain() {
		
		//inicializa o chain
		this.chainDollar50 = new Dollar50Dispenser();
		DispenseChain chainDollar20 = new Dollar20Dispenser();
		DispenseChain chainDollar10 = new Dollar10Dispenser();
		
		//set of chain of responsibility
		chainDollar50.setNextChain(chainDollar20);
		chainDollar20.setNextChain(chainDollar10);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ATMDispenseChain atm = new ATMDispenseChain();
		
		while(true) {
			
			int amount = 0;
			System.out.println("Entre com o valor do saque! Notas disponiveis: 10 | 20 | 50");
			
			Scanner in = new Scanner(System.in);
			amount = in.nextInt();
			if ((amount%10) != 0 ) {
				System.out.println("O valor deverar ser multiplo de 10, Notas disponiveis: 10 | 20 | 50");
				return;
			}
			
			atm.chainDollar50.dispense(new Currency(amount));
			
		}
		
		
		
	}
	
	
	
}
