package edu.cugb.xg.javaee.dao;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.CartItem;
import edu.cugb.xg.javaee.bean.Dish;
import edu.cugb.xg.javaee.bean.Users;

public class CartDAOImpl extends baseDAO implements CartDAO{

	@Override
	public ArrayList<CartItem> findCartItem(Users user) {
		// TODO Auto-generated method stub
		String sql = "select cartid Cartid,dishid Dishid,quantity Quantity from cart where username = ?";
		
		Object[] params= {user.getUsername()};
		return findObjs(sql, params, CartItem.class);
	}

	@Override
	public int insertCartItem(int dishid , String username, int quantity) {
		// TODO Auto-generated method stub
		String sql = "insert into cart (dishid,username,quantity) values (?,?,?);";
		Object[] params= {dishid,username,quantity};
		return modifyObj(sql,params);
	}

	@Override
	public int updateCartItem(int cartid,int quantity) {
		// TODO Auto-generated method stub
		String sql = "update cart set quantity = ? where cartid = ?;";
		Object[] params = {quantity,cartid};
		return modifyObj(sql,params);
	}

	@Override
	public int deleteCartItem(int cartid) {
		// TODO Auto-generated method stub
		String sql = "delete from cart where cartid = ?;";
		Object[] params = {cartid};
		return modifyObj(sql,params);
	}

	@Override
	public int deleteAllCartItem(Users user) {
		// TODO Auto-generated method stub
		String sql = "delete from cart where username = ?;";
		Object[] params = {user.getUsername()};
		return modifyObj(sql,params);
	}

	@Override
	public CartItem searchCartItem(int dishid, String username) {
		// TODO Auto-generated method stub
		String sql = "select quantity Quantity from cart where dishid = ? and username = ?;";
		Object[] param = {dishid,username};
		return (CartItem)findObj(sql,param,CartItem.class);
	}

}
