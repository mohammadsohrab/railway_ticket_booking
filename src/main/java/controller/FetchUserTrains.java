package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Train_dao;
import dto.Trains;
import dto.Users;

@WebServlet("/usertraininfo")
public class FetchUserTrains extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Train_dao dao=Train_dao.getInstance();
	Users users=(Users)request.getSession().getAttribute("users");
	if(users==null){
		response.getWriter().print("<h1>Session Expired Login or Register Again</h1>");
		request.getRequestDispatcher("home.html").include(request, response);
	}
	else{	
		List<Trains> trains=dao.fetchAll();

		if(trains.isEmpty()){
			response.getWriter().print("<h6 style='color:red'>*No railway record found!!!</h6>");
			request.getRequestDispatcher("ManagementHome.html");
		}else{
			request.setAttribute("trains", trains);
			request.getRequestDispatcher("UserFetchTrains.jsp").forward(request, response);;
		}
		
	}
	}
}
