package edu.cugb.xg.javaee.bean;

public class Cart {
	private int cartid;
	private Dish dish;
	private int quantity;
	public Cart(int cartid,Dish dish,int quantity) {
		// TODO Auto-generated constructor stub
		this.cartid = cartid;
		this.dish = dish;
		this.quantity = quantity;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
