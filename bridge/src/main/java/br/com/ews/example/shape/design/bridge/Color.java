package br.com.ews.example.shape.design.bridge;

/**
 * Segundo o GOF, o design pattern Bridge tem como objetivo desacoplar uma abstração de sua implementação,
 * permitindo que ambas variem de forma independente 
 * <p>
 * A implementação do design pattern bride segue a noção de preferir composição sobre herança.
 * <p>
 * O design pattern Bridge pode ser usado quando ambos abstração e implementação 
 * pode ter hierarquias diferentes de forma independente e queremos esconder a 
 * implementação do aplicativo cliente.
 */
public interface Color {
	
	void applyColor();
	
}
