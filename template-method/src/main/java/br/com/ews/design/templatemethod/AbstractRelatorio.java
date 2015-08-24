package br.com.ews.design.templatemethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
	Template Method é uma técnica de modelagem de classes abstratas e sub-classes, que se baseia na seguinte idéia:
	<p>
	1. Definimos uma classe abstrata com métodos abstratos e métodos concretos
	<p>
	2. Nos métodos concretos da classe abstrata, definimos a estrutura dos algoritmos, chamando seus
	métodos abstratos, mesmo sem saber qual será a implementação
	<p>
	3. Definimos sub-classes que implementam os métodos abstratos.
 
 * @author Eduardo Wallace
 * @since 22/07/2015
 *
 */
public abstract class AbstractRelatorio {
		
	protected String montaCabecalho() {
		StringBuilder sb = new StringBuilder();
		sb.append("Empresa: ")
			.append("WallSystem Consultoria em Informatica - ")
			.append("CNPJ: ")
			.append("57.755.457/7260-94");
		return sb.toString();
	}
	
	protected String montaRodape() {
		StringBuilder sb = new StringBuilder();
		sb.append("Todos os Direitos reservados. ")
		.append(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))
		.append("\n").append("--------------------------------------------------------------------------------------");
		return sb.toString();
	}
	
	public abstract String montaCorpo();
	
	protected void montaRelatorio() {
		System.out.println(montaCabecalho());
		System.out.println();
		System.out.println(montaCorpo());
		System.out.println();
		System.out.println(montaRodape());
	}

}