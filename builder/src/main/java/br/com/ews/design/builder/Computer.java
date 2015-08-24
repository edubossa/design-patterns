package br.com.ews.design.builder;

/**
 * <b>Builder Pattern Implementation</b>
 * <p>
 * 1- First of all you need to create a static nested class and then copy all
 * the arguments from the outer class to the Builder class. We should follow the
 * naming convention and if the class name is Computer then builder class should
 * be named as ComputerBuilder.
 * <p>
 * 2- The Builder class should have a public constructor with all the required
 * attributes as parameters.
 * <p>
 * 3- Builder class should have methods to set the optional parameters and it
 * should return the same Builder object after setting the optional attribute.
 * <p>
 * 4- The final step is to provide a build() method in the builder class that
 * will return the Object needed by client program. For this we need to have a
 * private constructor in the Class with Builder class as argument.
 */
public class Computer {

	// parametros obrigatorios
	private String HDD;
	private String RAM;

	// parametros opcionais
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	private Computer(ComputerBuilder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}
	
	public static ComputerBuilder create(String HDD, String RAM) {
		return new ComputerBuilder(HDD, RAM);
	}

	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", isGraphicsCardEnabled=" + isGraphicsCardEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}

	public static class ComputerBuilder {

		// parametros obrigatorios
		private String HDD;
		private String RAM;

		// parametros opcionais
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		public ComputerBuilder(String HDD, String RAM) {
			this.HDD = HDD;
			this.RAM = RAM;
		}

		public ComputerBuilder withGraphicsCardEnnable(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public ComputerBuilder withBuetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public Computer builder() {
			return new Computer(this);
		}

	}

}
