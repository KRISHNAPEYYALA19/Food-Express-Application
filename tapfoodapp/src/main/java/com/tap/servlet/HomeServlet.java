package com.tap.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.models.Restaurant;
@WebServlet("/restaurant")
public class HomeServlet  extends HttpServlet {
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
//		System.out.println("Hi from HomeServlet");	
			System.out.println("servelet called");
//			create the object of that class and call the method	and print the restaurants
//			use for each loop
			RestaurantDAOImpl dao = new RestaurantDAOImpl();
			 List<Restaurant> list = dao.getAllRestaurants();//method return list of restaurants	 
//			 send the  req control to html page	
			 req.setAttribute("restaurant", list);
			   
			 RequestDispatcher rd = req.getRequestDispatcher("restaurant.jsp");
			 rd.forward(req, resp);
//			 req,resp doest't have data so set the data to print inside html page
 
			 	/* for(Restaurant restaurantlist : list) {
				System.out.println(restaurantlist);
			}*/
	}
}
	
