package br.com.ews.example.shape.design.bridge.test;

import org.junit.Test;

import br.com.ews.example.shape.design.bridge.Color;
import br.com.ews.example.shape.design.bridge.GreenColor;
import br.com.ews.example.shape.design.bridge.Pentagon;
import br.com.ews.example.shape.design.bridge.RedColor;
import br.com.ews.example.shape.design.bridge.Shape;
import br.com.ews.example.shape.design.bridge.Triangle;

public class BridgePatternTest {

	@Test
	public void testTriangle() {
		Shape triangle = new Triangle(new RedColor());
		triangle.applyColor();
	}
	
	@Test
	public void testPentagon() {
		Shape pentagon = new Pentagon(new GreenColor());
		pentagon.applyColor();
	}
	
	@Test
	public void testRedColor() {
		Color red = new RedColor();
		red.applyColor();
	}

}
