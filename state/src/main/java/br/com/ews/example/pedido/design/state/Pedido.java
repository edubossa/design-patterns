package br.com.ews.example.pedido.design.state;

public class Pedido implements StatusPedido {

	private StatusPedido status;

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	@Override
	public void alterar(Pedido pedido) {
		status.alterar(this);
	}

	@Override
	public void cancelar(Pedido pedido) {
		status.cancelar(this);
	}

	@Override
	public void enviar(Pedido pedido) {
		status.enviar(this);
	}

}
