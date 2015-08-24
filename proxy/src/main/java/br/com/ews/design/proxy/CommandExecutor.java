package br.com.ews.design.proxy;

/**
 * Fornecer um substituto ou espaço reservado para outro objeto para controlar o acesso a ele.
 *<p> 
 * A definição em si é muito claro e padrão de proxy é usada quando queremos fornecer 
 * acesso controlado de uma funcionalidade
 * <p>
 * Usos comuns padrão Proxy são para controlar o acesso ou para fornecer uma implementação 
 * wrapper para um melhor desempenho
 */
public interface CommandExecutor {
	
	public void runCommand(String cmd) throws Exception;
	
}
