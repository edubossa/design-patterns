package br.com.ews.example.pedido.design.state;

public class PedidoEmProcessamento implements StatusPedido {

	@Override
	public void alterar(Pedido pedido) {
		System.out.println("Alterando o pedido em processamento!");
		
	}

	@Override
	public void cancelar(Pedido pedido) {
		System.out.println("Cancelando pedido em processamento!");
		pedido.setStatus(new PedidoCancelado());
	}

	@Override
	public void enviar(Pedido pedido) {
		System.out.println("Enviando Pedido");
		pedido.setStatus(new PedidoCancelado());
	}

}
