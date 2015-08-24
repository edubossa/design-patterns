package br.com.ews.design.test;

import org.junit.Test;

import br.com.ews.design.composite.Circle;
import br.com.ews.design.composite.Drawing;
import br.com.ews.design.composite.Shape;
import br.com.ews.design.composite.Triangle;

public class TestCompositePattern {

	@Test
	public void test() {
		
		Shape t1 = new Triangle();
		Shape t2 = new Triangle();
		Shape c1 = new Circle();
		
		c1.draw("BLUE");//TODO Posso chamar individualmente
		
		Drawing drawing = new Drawing();
		drawing.add(t1);
		drawing.add(t2);
		drawing.add(c1);
		
		drawing.draw("RED"); //TODO posso chamar para todos
		
		drawing.clear();
		
		drawing.add(t1);
		drawing.add(c1);
		drawing.draw("GREEN");
		
	}

}
