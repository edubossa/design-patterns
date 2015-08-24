package br.com.ews.example.logger.design.bridge;

public class LoggerBD extends Logger {

	public LoggerBD(Formatador formatador) {
		super(formatador);
	}

	@Override
	public void log(String texto) {
		String textoFormatado = formatador.format(texto);
		System.out.println("Logando na base de dados: " + textoFormatado);
	}

}
