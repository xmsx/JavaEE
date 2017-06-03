package edu.cugb.xg.javaee.dao;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.*;
import edu.cugb.xg.javaee.bean.Dish;

public interface CartDAO {
	
	
	public ArrayList<CartItem> findCartItem(Users user);
	
	public int insertCartItem(int dishid,String username,int quantity);
	
	public CartItem searchCartItem(int dishid,String username);
	
	public int updateCartItem(int cartid,int quantity);
	
	public int deleteAllCartItem(Users user);
	
	public int deleteCartItem(int cartid);

}