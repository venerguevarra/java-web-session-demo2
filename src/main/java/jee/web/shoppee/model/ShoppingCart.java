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
        this.items.put(item.getId(), item);
    }

    public int getGrandTotal() {
        int grandTotal = 0;
        for (CartItem item : getItems()) {
            grandTotal += item.getPrice();
        }
        return grandTotal;
    }

    public List<CartItem> getItems() {
        return new ArrayList<CartItem>(items.values());
    }

    public int getCount() {
        return items.size();
    }
}
