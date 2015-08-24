package br.com.ews.example.transacao.design.state;

public class Capturada implements StatusTransacao {

	@Override
	public void doAction() {
		System.out.println("CAPTURADA");
	}

}
