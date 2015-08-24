package br.com.ews.design.strategy;

/**
 * Strategy pattern is one of the behavioral design pattern. Strategy pattern 
 * is used when we have multiple algorithm for a specific task and client 
 * decides the actual implementation to be used at runtime. 
 * <p>
 * For our example, we will try to implement a simple Shopping Cart where we have 
 * two payment strategies – using Credit Card or using PayPal
 */
public interface PaymentStrategy {
	void pay(int amount);
}
