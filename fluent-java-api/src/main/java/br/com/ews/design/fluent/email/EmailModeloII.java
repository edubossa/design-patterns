package br.com.ews.design.fluent.email;

import java.util.ArrayList;
import java.util.List;

/**
 * {
 * 	"id":0,"assunto":"Pagamento Gateway","texto":"<html><body><h1>Teste cc</h1>NTK</body></html> 
 * 	credito", 	
 * 	"remetente":{"id":1}, 
 * 	"destinatarios":["eduardo.silva@ntk-consult.com.br"], "ccAddresses":["edubossa@gmail.com"]
 * }
 * 
 * @author Eduardo Wallace
 *
 */
public class EmailModeloII {
	
	private String assunto;
	private String mensagem;
	private boolean anexo;
	private List<String> destinatarios;
	
	public String getAssunto() {
		return assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public boolean isAnexo() {
		return anexo;
	}

	public List<String> getDestinatarios() {
		return destinatarios;
	}
	
	private EmailModeloII(EmailModeloIIlBuilder build){
		this.assunto = build.assunto;
		this.mensagem = build.mensagem;
		this.anexo = build.anexo;
		this.destinatarios = build.destinatarios;
	}
	
	public static EmailModeloIIlBuilder create() {
		return new EmailModeloIIlBuilder();
	}

	public static class EmailModeloIIlBuilder {
		
		private String assunto;
		private String mensagem;
		private boolean anexo;
		
		private List<String> destinatarios;
		
		private EmailModeloIIlBuilder() {
			this.destinatarios = new ArrayList<>();
		}
		
		public EmailModeloIIlBuilder withAssunto(String assunto) {
			this.assunto = assunto;
			return this;
		}
		
		public EmailModeloIIlBuilder withMensagem(String mensagem) {
			this.mensagem = mensagem;
			return this;
		}
		
		public EmailModeloIIlBuilder withAnexo(boolean anexo) {
			this.anexo = anexo;
			return this;
		}
		
		public EmailModeloIIlBuilder addDestinatario(String destinatario) {
			this.destinatarios.add(destinatario);
			return this;
		}
		
		public EmailModeloII build() {
			return new EmailModeloII(this);
		}
	}
		

	@Override
	public String toString() {
		return "Email [assunto=" + assunto + ", mensagem=" + mensagem + ", anexo=" + anexo + "]";
	}
	
}
