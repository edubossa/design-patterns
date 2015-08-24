package br.com.ews.example.logger.design.bridge;

public abstract class Logger {

	protected Formatador formatador;

	public Logger(Formatador formatador) {
		this.formatador = formatador;
	}

	public abstract void log(String texto);

}
