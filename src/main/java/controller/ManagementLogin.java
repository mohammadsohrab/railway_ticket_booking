package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManagementLogin")
public class ManagementLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		if(email.equals("adim")){
			if(pass.equals("adim")){
				resp.getWriter().print("<h1 style='color:green'>Successfully Login</h1>");
				req.getRequestDispatcher("ManagementHome.html").include(req, resp);
			}else{
				resp.getWriter().print("<h1 style='color:red'>Invalid password</h1>");
				req.getRequestDispatcher("ManagementLogin.html").include(req, resp);
			}
		}else{
			resp.getWriter().print("<h1 style='color:red'>Invalid User Id</h1>");
			req.getRequestDispatcher("ManagementLogin.html").include(req, resp);
		}
	}
}
