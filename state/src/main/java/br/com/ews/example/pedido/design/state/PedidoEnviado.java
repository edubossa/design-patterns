package br.com.ews.example.pedido.design.state;

public class PedidoEnviado implements StatusPedido {

	@Override
	public void alterar(Pedido pedido) {
		throw new IllegalStateException("Nao e possivel alterar pois o pedido ja foi enviado");
	}

	@Override
	public void cancelar(Pedido pedido) {
		throw new IllegalStateException("Nao e possivel cancelar pois o pedido ja foi enviado");
	}

	@Override
	public void enviar(Pedido pedido) {
		throw new IllegalStateException("O pedido ja foi enviado");
	}

}
