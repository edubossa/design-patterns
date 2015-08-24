package br.com.ews.design.composite;

/**
 * Leaf implements base component and these are the building block for the composite.
 */
public class Circle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Circle with color "+fillColor);
	}

}
