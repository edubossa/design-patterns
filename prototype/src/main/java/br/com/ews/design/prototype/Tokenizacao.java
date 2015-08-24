package br.com.ews.design.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Tokenizacao implements Cloneable {

	private List<String> tokens;

	public Tokenizacao() {
		tokens = new ArrayList<>();
	}

	public Tokenizacao(List<String> tokens) {
		this.tokens = tokens;
	}

	public List<String> getTokens() {
		return tokens;
	}

	/**
	 * Simula leitura de todos os tokens do BD
	 */
	public void loadDados() {
		for (int i = 0; i < 5; i++) {
			tokens.add(UUID.randomUUID().toString());
		}
	}
	
	/*
	 * TODO e necessario sobreescrever o metodo clone, garantindo assim uma copia
	 * fiel aos objetos, para manipulacao dos tokens, sem alterar o estado da copia original.
	 *
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<>();
		/*for(String token : this.getTokens()) {
			temp.add(token);
		}*/
		this.getTokens().forEach(s ->  temp.add(s)); //TODO lambda java se 8
		
		return new Tokenizacao(temp);
	}

}
