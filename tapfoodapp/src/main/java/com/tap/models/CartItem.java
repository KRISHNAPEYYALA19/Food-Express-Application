package com.tap.models;

public class CartItem {
    private int cartId;
    private String name;
    private int quantity;
    private double price;
    private String imagePath;

    public CartItem() {}

   
    public CartItem(int cartId, String name, int quantity, double price, String imagePath) {
		super();
		this.cartId = cartId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.imagePath = imagePath;
	}


	public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return cartId;
    }
    public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public double getTotalPrice() {
    	return price * quantity;
    }
    
    

    @Override
    public String toString() {
        return "CartItem [cartId=" + cartId + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}
