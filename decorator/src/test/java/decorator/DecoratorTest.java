package decorator;

import org.junit.Test;

import br.com.ews.design.decorator.BasicCar;
import br.com.ews.design.decorator.Car;
import br.com.ews.design.decorator.LuxuryCar;
import br.com.ews.design.decorator.SportCar;

public class DecoratorTest {

	@Test
	public void testSportCar() {
		Car sportCar = new SportCar(new BasicCar());
		sportCar.assemble();
	}
	
	@Test
	public void testLuxuryCar() {
		Car car = new LuxuryCar(new SportCar(new BasicCar()));
		car.assemble();
	}

}
