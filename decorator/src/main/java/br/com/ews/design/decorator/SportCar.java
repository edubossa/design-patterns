package br.com.ews.design.decorator;

/**
 * Concrete Decorators – Extending the base decorator functionality and modifying 
 * the component behavior accordingly
 */
public class SportCar extends CarDecorator {

	public SportCar(Car car) {
		super(car);
	}

	@Override
	public void assemble() {
		car.assemble();
		System.out.println("Adicionando recursos de Sport Car");
	}
	
	
	
}
