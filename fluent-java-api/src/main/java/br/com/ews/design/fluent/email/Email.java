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
public class Email {

	private String assunto;
	private String mensagem;
	private boolean anexo;
	private List<String> destinatarios;

	public Email() {
		destinatarios = new ArrayList<>();
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isAnexo() {
		return anexo;
	}

	public void setAnexo(boolean anexo) {
		this.anexo = anexo;
	}

	public List<String> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(List<String> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public static EmailBuilder create() {
		return new EmailBuilder();
	}

	@Override
	public String toString() {
		return "Email [assunto=" + assunto + ", mensagem=" + mensagem + ", anexo=" + anexo + ", destinatarios="
				+ destinatarios + "]";
	}

}
