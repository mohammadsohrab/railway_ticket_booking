package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Users_dao;
import dto.Users;


@WebServlet("/ForgetPassword")
public class ForgetPasswod extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(req.getParameter("id"));
		long phone=Long.parseLong(req.getParameter("ph"));
		Date dob=Date.valueOf(req.getParameter("dob"));
		String pass=req.getParameter("pass");
		Users_dao dao=Users_dao.getInstance();
		Users users=dao.find(id);
		if(users==null){
			resp.getWriter().print("<h1 style='color:red'>This User Not Found?</h1>");
			req.getRequestDispatcher("ForgetPassword.html").include(req, resp);
		}else{
			if(users.getMobile()==phone&&dob.equals(users.getDob())){
				users.setPassword(pass);
				dao.update(users);
				resp.getWriter().print("<h1 style='color:green'>This User id and Phone is present and password updated !!!</h1>");
				resp.getWriter().print("<p style='color:blue'>*now you can Login easily...</p>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}else{
				resp.getWriter().print("<h1 style='color:red'>This phone no is not found!!!</h1>");
				req.getRequestDispatcher("ForgetPassword.html").include(req, resp);
			}
				
		}
	}
}
