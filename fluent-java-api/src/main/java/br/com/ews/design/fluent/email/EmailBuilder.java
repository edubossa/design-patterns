package br.com.ews.design.fluent.email;

public class EmailBuilder {
	
	private Email email;
	
	public EmailBuilder() {
		email = new Email();
	}
	
	public EmailBuilder withAssunto(String assunto) {
		email.setAssunto(assunto);
		return this;
	}
	
	public EmailBuilder withMensagem(String mensagem) {
		email.setMensagem(mensagem);
		return this;
	}
	
	public EmailBuilder withAnexo(boolean anexo) {
		email.setAnexo(anexo);
		return this;
	}
	
	public EmailBuilder addDestinatario(String destinatario) {
		email.getDestinatarios().add(destinatario);
		return this;
	}
	
	public Email build() {
		return this.email;
	}

}
