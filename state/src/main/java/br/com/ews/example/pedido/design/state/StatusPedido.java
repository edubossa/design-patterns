package br.com.ews.example.pedido.design.state;

public interface StatusPedido {
	
	void alterar(Pedido pedido);
	
	void cancelar(Pedido pedido);
	
	void enviar(Pedido pedido);

}
