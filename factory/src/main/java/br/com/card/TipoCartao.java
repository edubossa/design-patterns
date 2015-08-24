package br.com.card;

public enum TipoCartao {
	
	VISA ("br.com.card.Visa"),
	MASTERCARD("br.com.card.Mastercard"),
	AMERICA_EXPRESS("br.com.card.AmericaExpress"),
	ELO("br.com.card.Elo");
	
	private String classe;

	private TipoCartao(String classe) {
		this.classe = classe;
	}

	public String getClasse() {
		return classe;
	}
		
}
