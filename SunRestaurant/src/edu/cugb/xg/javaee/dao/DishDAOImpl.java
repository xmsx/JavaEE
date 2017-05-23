package edu.cugb.xg.javaee.dao;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.Dish;

public class DishDAOImpl extends baseDAO implements DishDAO {
	@Override
	public Dish findDishByID(String dishid) {
		// TODO Auto-generated method stub
		String sql = "select * from dish where dishid= ?";
		Object[] params= {dishid};
		return (Dish)findObj(sql, params, Dish.class);
	}
	
	@Override
	public ArrayList<Dish> findDishes() {
		// TODO Auto-generated method stub
		String sql = "select dishid Dishid,name Dishname,price Price,description Dishdesc,img Img from dish";
		return this.findObjs(sql, null,Dish.class);
	}

	@Override
	public int insertDish(Dish dish) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalDishs(String strsql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Dish> findDishes(String strsql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
