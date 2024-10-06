package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Users_dao;
import dto.*;

@WebServlet("/register")
public class RegisterUser extends HttpServlet{
	
	protected  void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String fname=request.getParameter("fn");
		String lname=request.getParameter("ln");
		long phone=Long.parseLong(request.getParameter("ph"));
		String mail=request.getParameter("mail");
		String pass1=request.getParameter("pw1");
		String pass2=request.getParameter("pw2");
		Date dob=Date.valueOf(request.getParameter("dob"));
		String gender=request.getParameter("gen");
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		if(pass1.equals(pass2)){
			if(age>=18){
				Users user=Users.getInstance();
				user.setFirst_name(fname);
				user.setLast_name(lname);
				user.setMobile(phone);
				user.setMail(mail);
				user.setPassword(pass1);
				user.setAge(age);
				user.setGender(gender);
				user.setDob(dob);
				Users_dao dao=Users_dao.getInstance();
				dao.save(user);
				response.getWriter().print("<h1 style='color:green'>Account Created Succes<br>Your User id is :"+user.getId()+"</h1>");
				request.getRequestDispatcher("Login.html").include(request,response);

			}
			else{
				response.getWriter().print("<h3 style=color:'red'>your age not enough for sign in</h3>");
				request.getRequestDispatcher("Register.html").include(request, response);			
			}
		}
		else{
			response.getWriter().print("<h3 style=color:'red'>password miss match try again</h3>");
			request.getRequestDispatcher("Register.html").include(request, response);		
			}
	}
}
