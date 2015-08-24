package br.com.factory;

import br.com.card.Cartao;
import br.com.card.TipoCartao;

public class CartaoFactory {
	
	/** Inicializacao LAZY */
	private static CartaoFactory instance = null;
	
	private CartaoFactory(){}
	
	/** Synchronized em caso de inicializacao MultThread  **/
	public static synchronized CartaoFactory getInstance() {
		if (instance == null) {
			instance = new CartaoFactory();
		}
		return instance;
	}


	public Cartao create(TipoCartao tipoCartao){
		
		try {
			
			Object obj =  Class.forName(tipoCartao.getClasse()).newInstance();
			return (Cartao) obj; 
		
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		return null;
	}
	
	
}
