package br.com.ews.example.transacao.design.state;

public class Cancelada implements StatusTransacao {

	@Override
	public void doAction() {
		System.out.println("CANCELADA");
	}

}
