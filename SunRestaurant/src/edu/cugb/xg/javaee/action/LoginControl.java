package edu.cugb.xg.javaee.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cugb.xg.javaee.bean.Cart;
import edu.cugb.xg.javaee.bean.CartItem;
import edu.cugb.xg.javaee.bean.Dish;
import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.biz.CartService;
import edu.cugb.xg.javaee.biz.DishService;
import edu.cugb.xg.javaee.biz.UserService;
import edu.cugb.xg.javaee.utils.PageModel;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/loginControl")
public class LoginControl extends baseControl {
	private int pageSize = 2;// �ŵ������ļ�
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actiontype = request.getParameter("actiontype");
		switch (actiontype) {
		case "login":
			// ��¼
			loginCheck(request, response);
			break;
		case "pagelist":
			// ��ҳ��ʾ
			pageListView(request, response);
			break;
		case "detail":
			// ��ʾĳһ����Ʒ����ϸ��Ϣ
			showDishDetail(request, response);
			break;
		case "adddish":
			// ��ӹ��ﳵ
			add2Cart(request, response);
			break;
		case "adddish2":
			// ��Ʒϸ��ҳ����ӹ��ﳵ
			add2Cart2(request, response);
			break;
		case "showCart":
			// չʾ���ﳵ
			showCart(request, response);
			
		}

	}
	
	/**
	 * չʾ���ﳵ
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("loginuser");
		System.out.println(user.getUsername()+"111111111");
		
		DishService dishserv = new DishService();
		CartService cartserv = new CartService();
		
		ArrayList<CartItem> cartlist = cartserv.find4Cart(user);
		System.out.println(cartlist.size()+"222");
		ArrayList<Cart> cart = null;
		for(int i = 0; i < cartlist.size();i++){
			int dishid = cartlist.get(i).getDishid();
			Dish tmp = dishserv.get4Dish(dishid);
			cart.add(new Cart(cartlist.get(i).getCartid(),tmp,cartlist.get(i).getQuantity()));
		}
		request.setAttribute("cartitems", cart);
		rd = request.getRequestDispatcher("showCart.jsp");
		rd.forward(request, response);
	}

	/**
	 * ��Ʒϸ��ҳ����ӹ��ﳵ
	 * @param request
	 * @param response
	 */
	private void add2Cart2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ��ӹ��ﳵ
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void add2Cart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("loginuser");
		CartService cartserv = new CartService();
		int dishid = Integer.parseInt(request.getParameter("dishid"));
		cartserv.add2Dish(dishid, user.getUsername(), 1);
		//�ض��򵽱�ҳ
		RequestDispatcher rd = null;
		DishService dishserv = new DishService();
		int pageNO = Integer.parseInt(request.getParameter("pos"));;
		PageModel<Dish> pagemodel = dishserv.findDish4PageList(pageNO, pageSize);
		rd = request.getRequestDispatcher("show.jsp?pageNO=" + pageNO + "&totalpages=" + pagemodel.getTotalPages());
		rd.forward(request, response);
	}

	/***
	 * ��¼��֤
	 * 
	 * @param request
	 * @param response
	 */
	private void loginCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// step 1 ��ȡ�û��ύ���û����Ϳ���
		String username = request.getParameter("loginName");
		String password = request.getParameter("loginPass");
		Users loginuser = new Users();
		loginuser.setUsername(username);
		loginuser.setPassword(password);
		// step 2 ���ݿ���֤�û�
		UserService userserv = new UserService();
		RequestDispatcher rd = null;
		if (userserv.validateUser(loginuser)) {
//			response.sendRedirect("show.html");
			// ��֤ͨ�� ����ת��show.jsp
			HttpSession session = request.getSession(true);
			session.setAttribute("loginuser", loginuser);
			DishService dishserv = new DishService();
			// int pageSize = 6;
			int pageNO = 1;
			PageModel<Dish> pagemodel = dishserv.findDish4PageList(pageNO, pageSize);
			request.setAttribute("dishlist", pagemodel.getList());
			logger.debug(pagemodel.getTotalrecords());
			request.setAttribute("pageModel", pagemodel);
			//System.out.println(pagemodel.getList().get(0).getDishdesc());
			// rd = request.getRequestDispatcher("show.jsp");
			rd = request.getRequestDispatcher("show.jsp?pageNO=1&totalpages=" + pagemodel.getTotalPages());
			rd.forward(request, response);
		} else {
			// �������µ�¼
			response.sendRedirect("login.html");
			// request.getRequestDispatcher("login.html").forward(request,
			// response);
		}
	}

	/***
	 * ��ҳ��ʾ
	 * 
	 * @param request
	 * @param response
	 */
	private void pageListView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ǰҳ��
		logger.debug(request.getParameter("pageNO"));
		int pageNO = Integer.parseInt(request.getParameter("pageNO"));
		// ��ҳ��ѯ
		// int pageSize = 6;
		// ����pageModel����
		DishService dishserv = new DishService();
		PageModel<Dish> pagemodel = dishserv.findDish4PageList(pageNO, pageSize);
		// ��ת��showҳ��
		logger.debug(pagemodel.getList());
		request.setAttribute("dishlist", pagemodel.getList());
		
		request.setAttribute("pageModel", pagemodel);
		RequestDispatcher rd = request
				.getRequestDispatcher("show.jsp?pageNO=" + pageNO + "&totalpages=" + pagemodel.getTotalPages());
		rd.forward(request, response);

	}

	/**
	 * ��ʾĳһ����Ʒ����ϸ��Ϣ
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showDishDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		DishService dishserv = new DishService();
		RequestDispatcher rd = null;
		int dishid = Integer.parseInt(request.getParameter("dishid"));
		System.out.println(dishid+"-sadf");
		Dish dish= dishserv.get4Dish(dishid);
		request.setAttribute("dish", dish);
		rd = request.getRequestDispatcher("details.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
