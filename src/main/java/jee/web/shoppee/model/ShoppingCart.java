package jee.web.shoppee.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
	private Map<String, CartItem> items;

	public ShoppingCart() {
		this.items = new HashMap<>();
	}

	public void add(CartItem item) {
		final String itemId = item.getId();
		if (this.items.containsKey(itemId)) {
			CartItem existingCartItem = this.items.get(itemId);
			int quantity = existingCartItem.getQuantity() + 1;
			existingCartItem.setQuantity(quantity);
			this.items.put(itemId, existingCartItem);
		} else {
			this.items.put(itemId, item);
		}
	}
	
	public void remove(final String itemId) {
		if (this.items.containsKey(itemId)) {
			this.items.remove(itemId);
		}
	}

	public int getGrandTotal() {
		return getItems().stream().map(CartItem::getTotalPrice).reduce(0, (a, b) -> a + b);
	}
	
	public int getCount() {
		return getItems().stream().map(CartItem::getQuantity).reduce(0, (a, b) -> a + b);
	}

	public List<CartItem> getItems() {
		return new ArrayList<CartItem>(items.values());
	}

	
}
