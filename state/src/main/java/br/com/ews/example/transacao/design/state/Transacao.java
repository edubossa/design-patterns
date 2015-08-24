package br.com.ews.example.transacao.design.state;

public class Transacao implements StatusTransacao {

	private StatusTransacao status;

	public StatusTransacao getStatus() {
		return status;
	}

	public void setStatus(StatusTransacao status) {
		this.status = status;
	}

	@Override
	public void doAction() {
		status.doAction();
	}

}
