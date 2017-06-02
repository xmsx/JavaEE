package edu.cugb.xg.javaee.biz;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.CartItem;
import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.dao.CartDAO;

public class CartService {
	private CartDAO cartdao;
	public CartDAO getCartdao() {
		return cartdao;
	}
	public void setCartdao(CartDAO cartdao) {
		this.cartdao = cartdao;
	}

	public ArrayList<CartItem> find4cart(Users user){
		
		return cartdao.findCartItem(user);
		
	}

}
