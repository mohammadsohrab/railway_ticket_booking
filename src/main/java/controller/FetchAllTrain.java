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
@WebServlet("/fetchAllTrain")
public class FetchAllTrain extends HttpServlet {
	 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		Train_dao dao=Train_dao.getInstance();
		List<Trains> list=dao.fetchAll();		
		if(list.isEmpty()){
			response.getWriter().print("<h6 style='color:red'>*No railway record found!!!</h6>");
			request.getRequestDispatcher("ManagementHome.html");
		}else{
			
			request.setAttribute("list",list);
			request.getRequestDispatcher("FetchRailwayRecord.jsp").forward(request, response);;
		}
	}
}
