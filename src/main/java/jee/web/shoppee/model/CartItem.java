package jee.web.shoppee.model;

public class CartItem extends Product {
	private int quantity;
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotalPrice() {
		return getQuantity() * getPrice();
	}
}
