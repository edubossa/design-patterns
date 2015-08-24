package br.com.ews.design.templatemethod;

public class Main {
	
	
	public static void main(String[] args) {
		
		AbstractRelatorio relatorioFinanceiro = new RelatorioFinanceiro();
		AbstractRelatorio relatorioDespesas = new RelatorioDespesas();
		
		relatorioFinanceiro.montaRelatorio();
		relatorioDespesas.montaRelatorio();
	}
	
}