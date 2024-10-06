package controller ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.Users_dao;
import dto.Users;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId=Integer.parseInt(req.getParameter("id"));
		String pass=req.getParameter("pw");
		Users_dao dao=Users_dao.getInstance();
		Users users= dao.find(userId);
		if(users==null){
			resp.getWriter().print("<h1 style='color:red'>Invalid User Id</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}else{
			if(users.getPassword().equals(pass)){
				HttpSession session=req.getSession();
				session.setAttribute("users", users);
				resp.getWriter().print("<h1 style='color:green'>Successfully Login!!!</h1>");
				
				req.getRequestDispatcher("CustomerHome.html").include(req, resp);
			}
			else{
				resp.getWriter().print("<h1 style='color:red'>Invalid Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
	}
}
