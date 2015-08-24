package br.com.ews.example.shape.design.bridge;

public abstract class Shape {
	
	//composicao
	protected Color color;

	public Shape(Color color) {
		this.color = color;
	}
	
	public abstract void applyColor();
	
}
