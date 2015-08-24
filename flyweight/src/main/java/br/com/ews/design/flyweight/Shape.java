package br.com.ews.design.flyweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * O design pattern Flyweight é usado quando precisamos criar muitos objetos de 
 * uma determinada classe.
 * <p>
 * Uma vez que cada objeto consome espaço de memória que pode ser crucial para 
 * dispositivos de memória baixa, tais como dispositivos móveis ou sistemas 
 * embarcados, o design pattern flyweight podem ser aplicadas para reduzir a 
 * carga em memória através da partilhacao de objetos
 */
public interface Shape {
	
	public void draw(Graphics g, int x, int y, int width, int height, Color color);
}
