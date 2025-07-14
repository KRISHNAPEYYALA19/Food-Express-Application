package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.models.Menu;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
//	we can override any method doPost(),doGet(),service() methods 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//			System.out.println("Hi from MenuServlet");
//		we need to get the restaurantId by using getParameter 
//		it will give string downcast it to integer by parseInt()method
		
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		
		MenuDAOImpl dao = new MenuDAOImpl();
		List<Menu> allMenusByRestaurants = dao.getAllMenusByRestaurants(restaurantId);
		
		req.setAttribute("allMenus", allMenusByRestaurants);
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
	
	}

}
