package br.com.ews.design.fluent.email;

import java.util.ArrayList;
import java.util.List;

public class EmailModeloIII {
	
	private String assunto;
	private String mensagem;
	private boolean anexo;
	private List<String> destinatarios;

	private EmailModeloIII() {
		destinatarios = new ArrayList<>();
	}
	
	public EmailModeloIII withAssunto(String assunto) {
		this.assunto = assunto;
		return this;
	}
	
	public EmailModeloIII withMensagem(String mensagem) {
		this.mensagem = mensagem;
		return this;
	}
	
	public EmailModeloIII withAnexo(boolean anexo) {
		this.anexo = anexo;
		return this;
	}
	
	public EmailModeloIII addDestinatario(String destinatario) {
		this.destinatarios.add(destinatario);
		return this;
	}
	
	//------------------ getters --------------------------------------------//
	
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
	//------------------------------------------------------------------------//
	
	
	//---------------------- builder -----------------------------------------//
	
	public static EmailModeloIII create() {
		return new EmailModeloIII();
	}
	
	public EmailModeloIII build() {
		return this;
	}
	//------------------------------------------------------------------------//
	
	@Override
	public String toString() {
		return "EmailModeloIII [assunto=" + assunto + ", mensagem=" + mensagem + ", anexo=" + anexo + ", destinatarios="
				+ destinatarios + "]";
	}
	
}
