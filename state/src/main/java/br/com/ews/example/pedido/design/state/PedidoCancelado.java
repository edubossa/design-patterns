package br.com.ews.example.pedido.design.state;

public class PedidoCancelado implements StatusPedido {

	@Override
	public void alterar(Pedido pedido) {
		throw new IllegalStateException("Nao e possivel alterar um pedido cancelado");
	}

	@Override
	public void cancelar(Pedido pedido) {
		System.out.println("PEDIDO CANCELADO COM SUCESSO!");
	}

	@Override
	public void enviar(Pedido pedido) {
		throw new IllegalStateException("Nao e possivel enviar um pedido cancelado!");
	}

}
