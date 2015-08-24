package br.com.ews.design.strategy;

public class PaypalStrategy implements PaymentStrategy {

	private String emailID;
	private String password;

	public PaypalStrategy(String emailID, String password) {
		this.emailID = emailID;
		this.password = password;
	}

	public String getEmailID() {
		return emailID;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " Pago usando Paypal");
	}

}
