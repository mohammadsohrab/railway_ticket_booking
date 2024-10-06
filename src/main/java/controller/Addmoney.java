package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Users_dao;
import dto.Users;

@WebServlet("/addmoney")
public class Addmoney extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users=(Users)req.getSession().getAttribute("users");
		if(users==null){
			resp.getWriter().print("<h1>Session Expired Login Again</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}else{
			Users_dao dao=Users_dao.getInstance();
			users.setWallet(users.getWallet()+ Double.parseDouble(req.getParameter("amount")));
			dao.update(users);
			resp.getWriter().print("<p>**Money Add successfully!!");
			req.getRequestDispatcher("CustomerHome.html").include(req, resp);
		}
	}
}
