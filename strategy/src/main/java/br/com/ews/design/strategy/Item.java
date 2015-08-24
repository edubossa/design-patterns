package br.com.ews.design.strategy;

public class Item {

	private String upcCode;
	private int price;

	public Item(String upcCode, int price) {
		this.upcCode = upcCode;
		this.price = price;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [upcCode=" + upcCode + ", price=" + price + "]";
	}
	
}
