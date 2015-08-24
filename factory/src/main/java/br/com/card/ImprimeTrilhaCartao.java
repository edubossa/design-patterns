package br.com.card;

import br.com.factory.CartaoFactory;

public class ImprimeTrilhaCartao {
	
	
	public void imprime(TipoCartao tipoCartao) {
		Cartao cartao = CartaoFactory.getInstance().create(tipoCartao);
		System.out.println("-------------------[Trilha " + tipoCartao.name() + "]------------------------");
		System.out.println(cartao.trilha());
		System.out.println("-------------------------------------------------------------------------");
	}	
	
}
