package br.com.ews.example.logger.design.bridge.test;

import org.junit.Test;

import br.com.ews.example.logger.design.bridge.Formatador;
import br.com.ews.example.logger.design.bridge.FormatadorData;
import br.com.ews.example.logger.design.bridge.FormatadorHora;
import br.com.ews.example.logger.design.bridge.Logger;
import br.com.ews.example.logger.design.bridge.LoggerArquivo;
import br.com.ews.example.logger.design.bridge.LoggerBD;

public class LoggerTest {

	@Test
	public void testLoggerBD() {
		Logger log = new LoggerBD(new FormatadorHora());
		log.log("Eduardo Wallace");
	}
	
	@Test
	public void testLoggerArquivo() {
		Logger log = new LoggerArquivo(new FormatadorData());
		log.log("Eduardo Wallace");
	}
	
	@Test
	public void testFormatador(){
		Formatador format = new FormatadorHora();
		String textoFormatado = format.format("Usando apenas o formatador");
		System.out.println(textoFormatado);
	}

}
