package br.com.ews.design.prototype.test;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import br.com.ews.design.prototype.Tokenizacao;

public class TestTokenizacao {
	
	Tokenizacao tokenizacao;
	
	@Before
	public void init() {
		tokenizacao = new Tokenizacao();
		tokenizacao.loadDados();
	}
	
	@Test
	public void test() throws CloneNotSupportedException {
		
		Tokenizacao t1 = (Tokenizacao) this.tokenizacao.clone();
		t1.getTokens().add(UUID.randomUUID().toString());
		
		System.out.println(t1.getTokens().size());
		System.out.println(this.tokenizacao.getTokens().size());
		System.out.println(t1.getTokens());
		
		Tokenizacao t2 = (Tokenizacao) this.tokenizacao.clone();
		System.out.println(t2.getTokens());
		
		Tokenizacao t3 = (Tokenizacao) this.tokenizacao.clone();
		t3.getTokens().add(UUID.randomUUID().toString());
		t3.getTokens().add(UUID.randomUUID().toString());
		t3.getTokens().add(UUID.randomUUID().toString());
		
		System.out.println(t3.getTokens().size());
		System.out.println(t2.getTokens().size());
		System.out.println(t1.getTokens().size());
		System.out.println(this.tokenizacao.getTokens().size());
		
		System.out.println(t3.getTokens());
		
	}

}
