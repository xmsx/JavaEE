package edu.cugb.xg.javaee.bean;

import java.io.Serializable;
import edu.cugb.xg.javaee.bean.Dish;

public class CartItem implements Serializable {
	private int cartid;
	private int dishid;
	private int quantity;
	public CartItem(int id,int dishtoadd, int number){
		this.cartid = id;
		this.dishid = dishtoadd;
		this.quantity = number;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getDishid() {
		return dishid;
	}
	public void setDishid(int dishid) {
		this.dishid = dishid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
