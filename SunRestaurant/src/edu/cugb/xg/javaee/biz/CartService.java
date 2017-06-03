package edu.cugb.xg.javaee.biz;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.CartItem;
import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.dao.CartDAO;
import edu.cugb.xg.javaee.dao.CartDAOImpl;
import edu.cugb.xg.javaee.dao.DishDAO;
import edu.cugb.xg.javaee.dao.DishDAOImpl;
import edu.cugb.xg.javaee.utils.DAOFactory;

public class CartService {
	private CartDAO cartdao = (CartDAO) DAOFactory.newInstance("CartDAO");
	public CartDAO getCartdao() {
		return cartdao;
	}
	public void setCartdao(CartDAO cartdao) {
		this.cartdao = cartdao;
	}

	public ArrayList<CartItem> find4Cart(Users user){
		
		return cartdao.findCartItem(user);
		
	}
	public int add2Dish(int dishid,String username, int quantity){
		return cartdao.insertCartItem(dishid, username, quantity);
	}
	
	public CartItem searchCartItem(int dishid,Users user){
		return cartdao.searchCartItem(dishid, user.getUsername());
	}
	
	public int updatequantity(int cartid, int quantity){
		return cartdao.updateCartItem(cartid, quantity);
	}
	
	public int deleteCart(Users user){
		return cartdao.deleteAllCartItem(user);
	}
}
