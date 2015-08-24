package br.com.card;

public class Main {
	
	public static void main(String[] args) {
		
		new ImprimeTrilhaCartao().imprime(TipoCartao.AMERICA_EXPRESS);
		new ImprimeTrilhaCartao().imprime(TipoCartao.MASTERCARD);
		
		
	}
	
}
