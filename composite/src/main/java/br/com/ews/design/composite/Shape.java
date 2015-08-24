package br.com.ews.design.composite;


/**
 * http://www.journaldev.com/1535/composite-design-pattern-in-java-example-tutorial
 * 
 * <p>
    Composite Pattern consists of following objects:
    <p>
	Base Component – Base component is the interface for all objects in the composition, client 
	program uses base component to work with the objects in the composition. It can be an interface 
	or an abstract class with some methods common to all the objects.
	<p>
	Leaf – Defines the behaviour for the elements in the composition. It is the building block for the 
	composition and implements base component. It doesn’t have references to other Components.
	<p>
	Composite – It consists of leaf elements and implements the operations in base component.
 * 
 * <p>
 * 
 * Base component defines the common methods for leaf and composites, we can create a class 
 * Shape with a method draw(String fillColor) to draw the shape with given color.
 * 
 */
public interface Shape {
	
	public void draw(String fillColor);
	
}
