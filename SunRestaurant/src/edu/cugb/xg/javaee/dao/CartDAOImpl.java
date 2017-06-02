package edu.cugb.xg.javaee.dao;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.CartItem;
import edu.cugb.xg.javaee.bean.Dish;
import edu.cugb.xg.javaee.bean.Users;

public class CartDAOImpl extends baseDAO implements CartDAO{

	@Override
	public ArrayList<CartItem> findCartItem(Users user) {
		// TODO Auto-generated method stub
		String sql = "select * from cart where userid = ?";
		Object[] params= {user.getUserid()};
		return findObjs(sql,params,user.getClass());
	}

	@Override
	public int insertCartItem(Dish dish , Users user, int quantity) {
		// TODO Auto-generated method stub
		String sql = "insert into cart (dishid,username,quantity) values (?,?,?);";
		Object[] params= {dish.getDishid(),user.getUsername(),quantity};
		return modifyObj(sql,params);
	}

	@Override
	public int updateCartItem(int cartid, int quantity) {
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

}
