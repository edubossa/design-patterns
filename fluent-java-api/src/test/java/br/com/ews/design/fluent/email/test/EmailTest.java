package br.com.ews.design.fluent.email.test;

import org.junit.Test;

import br.com.ews.design.fluent.email.Email;
import br.com.ews.design.fluent.email.EmailModeloII;
import br.com.ews.design.fluent.email.EmailModeloIII;

public class EmailTest {

	@Test
	public void testEmail() {
		Email email = Email.create().withAssunto("Pagamento via Boleto")
				.withMensagem("Segue em anexo boleto mensal")
				.withAnexo(true)
				.addDestinatario("edubossa@gmail.com")
				.addDestinatario("desenv@ntk.com.br")
				.build();
		
		System.out.println(email);
	}
	
	@Test
	public void testModeloII() {
		EmailModeloII email = EmailModeloII.create()
				.withAssunto("Pagamento Gateway")
				.withMensagem("Segue em anexo o envio de pagamento por email")
				.withAnexo(true)
				.addDestinatario("eduardo.silva@consult.com.br")
				.addDestinatario("edubossa@gmail.com")
				.addDestinatario("desenv@ntk.com.br")
				.build();
		
		System.out.println("Assunto: " + email.getAssunto());
		email.getDestinatarios().forEach(System.out::println);
				
		System.out.println(email);
	}
	
	@Test
	public void testModeloIII() {
		
		EmailModeloIII email = EmailModeloIII.create()
				.withAssunto("Cancelamento Proposta")
				.withMensagem("sua proposta foi cancelada");
		
		System.out.println(email);
		
		email.addDestinatario("edubossa@gmail.com")
			.addDestinatario("joao@gmail.com")
			.addDestinatario("infra@gmail.com");
		
		System.out.println(email);
		
		EmailModeloIII copia = email.build(); //TODO objeto nao imutavel
		System.out.println(copia);
		
		email.withAnexo(true);
		
		
		System.out.println(email);
	}
	

}
