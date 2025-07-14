package com.tap.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	
    private Map<Integer, CartItem> items = new HashMap<>();

    
    public Map<Integer, CartItem> getItems() {
        return items;
    }
    

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
    

    
    public void addCartItem(CartItem item) {
        int itemId = item.getItemId();
        if (items.containsKey(itemId)) {
            CartItem existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(itemId, item);
        }
    }

    
    
    
    public void updateItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            if (quantity <= 0) {
                items.remove(itemId);
            } else {
                items.get(itemId).setQuantity(quantity);
            }
        }
    }

    
    
    
    public void removeCartItem(int itemId) {
        items.remove(itemId);
    }
   
    
    
    public double  getTotalPrice() {
    	return items.values().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }
    
    

    public void clear() {
        items.clear();
    }
}
