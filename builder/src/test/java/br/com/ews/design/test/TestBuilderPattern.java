package br.com.ews.design.test;

import org.junit.Test;

import br.com.ews.design.builder.Computer;

public class TestBuilderPattern {

	@Test
	public void testParametroObrigatorios() {
		Computer c = Computer.create("500 GB", "8 GB").builder();
		System.out.println(c);
	}
	
	@Test
	public void testParametroObrigatoriosOpcionais() {
		Computer c = new Computer.ComputerBuilder("500 GB", "8 GB")
				.withBuetoothEnabled(true).withGraphicsCardEnnable(true).builder();
		System.out.println(c);
	}

}
