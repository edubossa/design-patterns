package strategy;

import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import br.com.ews.design.strategy.CreditCardStrategy;
import br.com.ews.design.strategy.Item;
import br.com.ews.design.strategy.PaypalStrategy;
import br.com.ews.design.strategy.ShoppingCart;

public class ShoppingCartTest {
	
	ShoppingCart cart = new ShoppingCart();
	
	@Before
	public void init() {
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
		cart.addItem(new Item(UUID.randomUUID().toString().substring(0, 6), new Random().nextInt(5000)));
	}
	
	@Test
	public void testPaypal() {
		cart.pay(new PaypalStrategy("EWS-PAYPAL", "LPOJMNJK009987"));		
	}
	
	@Test
	public void testCreditCard() {
		cart.pay(new CreditCardStrategy("Eduardo Wallace", "89983 342342 23444123 12345", "689", "01/2020"));
	}

}
