package br.com.ews.example.pedido.test;

import org.junit.Test;

import br.com.ews.example.pedido.design.state.Pedido;
import br.com.ews.example.pedido.design.state.PedidoEmProcessamento;
import br.com.ews.example.pedido.design.state.StatusPedido;

public class PedidoTest {

	@Test
	public void testPedido() {
		Pedido pedido = new Pedido();
		StatusPedido processamento = new PedidoEmProcessamento();
		pedido.setStatus(processamento);
		pedido.cancelar(pedido);
	}

}
