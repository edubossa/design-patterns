package br.com.ews.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * A composite object contains group of leaf objects and we should provide some helper 
 * methods to add or delete leafs from the group. We can also provide a method 
 * to remove all the elements from the group.
 */
public class Drawing implements Shape {
	
	private List<Shape> shapes = new ArrayList<>();
	
	@Override
	public void draw(String fillColor) {	
		for(Shape shape: shapes) {
			shape.draw(fillColor);
		}
	}
	
	public void add(Shape s){
		this.shapes.add(s);
	}
	
	public void remove(Shape s) {
		this.shapes.remove(s);
	}
	
	public void clear() {
		System.out.println();
		System.out.println("Clearing all the shapes from drawing");
		System.out.println();
		this.shapes.clear();
	}
	
}
