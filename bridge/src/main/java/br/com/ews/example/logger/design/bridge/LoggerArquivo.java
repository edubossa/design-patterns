package br.com.ews.example.logger.design.bridge;

public class LoggerArquivo extends Logger {

	public LoggerArquivo(Formatador formatador) {
		super(formatador);
	}

	@Override
	public void log(String texto) {
		String textoFormatado = formatador.format(texto);
		System.out.println("Logando em arquivo: " + textoFormatado);
	}

}
