package br.com.ews.example.logger.design.bridge;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatadorHora implements Formatador {

	@Override
	public String format(String texto) {
		System.out.println("Formatador hora");
		return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
				.concat(" ").concat(texto);
	}

}
