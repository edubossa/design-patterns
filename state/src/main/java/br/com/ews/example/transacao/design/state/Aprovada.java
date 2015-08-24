package br.com.ews.example.transacao.design.state;

public class Aprovada implements StatusTransacao {

	@Override
	public void doAction() {
		System.out.println("APROVADA");
	}

}
