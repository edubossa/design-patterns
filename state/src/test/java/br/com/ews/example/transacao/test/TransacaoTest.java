package br.com.ews.example.transacao.test;

import org.junit.Before;
import org.junit.Test;

import br.com.ews.example.transacao.design.state.Aprovada;
import br.com.ews.example.transacao.design.state.Cancelada;
import br.com.ews.example.transacao.design.state.Capturada;
import br.com.ews.example.transacao.design.state.StatusTransacao;
import br.com.ews.example.transacao.design.state.Transacao;

public class TransacaoTest {

	private Transacao transacao;
	
	@Before
	public void init(){
		transacao = new Transacao();
	}
	
	@Test
	public void testCaptura() {
		StatusTransacao status = new Capturada();
		transacao.setStatus(status);
		transacao.doAction();
	}
	
	@Test
	public void testCancelamento() {
		StatusTransacao status = new Cancelada();
		transacao.setStatus(status);
		transacao.doAction();
	}
	
	@Test
	public void testAprovacao() {
		StatusTransacao status = new Aprovada();
		transacao.setStatus(status);
		transacao.doAction();
	}
	
}
