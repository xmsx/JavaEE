package edu.cugb.xg.javaee.biz;

import java.util.ArrayList;

import edu.cugb.xg.javaee.dao.DishDAO;
import edu.cugb.xg.javaee.bean.Dish;
import edu.cugb.xg.javaee.utils.DAOFactory;
import edu.cugb.xg.javaee.utils.PageModel;

public class DishService {
	private DishDAO dishdao;

	public DishDAO getDishdao() {
		return dishdao;
	}

	public void setDishdao(DishDAO dishdao) {
		this.dishdao = dishdao;
	}
	
	/**
	 * @param pageNO
	 * @param pageSize
	 * @return
	 */
	public PageModel<Dish> findDish4PageList(int pageNO,int pageSize){
		dishdao = (DishDAO) DAOFactory.newInstance("DishDAO");
		String strsql = "select dishid Dishid,dishname Dishname,img Img,price Price from dish limit ?,?";
		int actualpageNO = (pageNO-1)*pageSize;
		Object[] params = {actualpageNO,pageSize};
		ArrayList<Dish> dishlist = dishdao.findDishes(strsql, params);
		System.out.println(dishlist.size()+"sdfa");
//		PageModel<Dish> pagemodel = new PageModel<Dish>();
//		pagemodel.setList(dishlist);
//		pagemodel.setPageNO(pageNO);
//		pagemodel.setPageSize(pageSize);
//		pagemodel.setTotalrecords(getTotalDishs());
		PageModel<Dish> pagemodel = new PageModel<Dish>(pageSize,pageNO,getTotalDishs(),dishlist);
		return pagemodel;
//		return dishdao.findDishs(strsql, params);
	}
	
	public int getTotalDishs(){
		dishdao = (DishDAO) DAOFactory.newInstance("DishDAO");
		String strsql = "select count(*) from dish";
		return dishdao.getTotalDishs(strsql);
	}
	
	public Dish showDish(int dishid){
		return dishdao.findDishByID(dishid);
	}
	
}
