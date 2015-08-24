package br.com.ews.design.decorator;

/**
 * Concrete Decorators – Extending the base decorator functionality and modifying 
 * the component behavior accordingly
 */
public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car car) {
		super(car);
	}

	@Override
	public void assemble() {
		car.assemble();
		System.out.println("Adicionando recursos Luxury Car");
	}
	
	

}
