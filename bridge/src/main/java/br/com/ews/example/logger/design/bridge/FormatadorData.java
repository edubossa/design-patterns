package br.com.ews.example.logger.design.bridge;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatadorData implements Formatador {

	@Override
	public String format(String texto) {
		System.out.println("Formatador Data");
		return LocalDate.now().format(DateTimeFormatter.ISO_DATE).concat(" ").concat(texto);
	}
	
}
