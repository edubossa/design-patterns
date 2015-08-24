package br.com.card;

import java.util.UUID;

public class Elo implements Cartao {

	@Override
	public String trilha() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}

}
