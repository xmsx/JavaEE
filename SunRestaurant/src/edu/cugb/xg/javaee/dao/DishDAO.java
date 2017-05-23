package edu.cugb.xg.javaee.dao;

import java.util.ArrayList;

import edu.cugb.xg.javaee.bean.Dish;

public interface DishDAO {
	
	public Dish findDishByID(String dishid);
	
	public ArrayList<Dish> findDishes();
	
	public int insertDish(Dish dish);
	
	public int getTotalDishs(String strsql);
	
	public ArrayList<Dish> findDishes(String strsql, Object[] params);

}
