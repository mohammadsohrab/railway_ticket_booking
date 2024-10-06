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

@WebServlet("/deletetrain")
public class DeleteTrain extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tnumber=Integer.parseInt(req.getParameter("trainnumber"));
		Train_dao dao=Train_dao.getInstance();
		dao.deletetrain(tnumber);
	
		List<Trains> list=dao.fetchAll();
		if(list.isEmpty()){
			resp.getWriter().print("<h6 style='color:red'>*train record deleted</h6>");
			req.getRequestDispatcher("ManagementHome.html");
			
		}else{
			resp.getWriter().print("<h6 style='color:green'>*train record deleted</h6>");
			req.setAttribute("list",list);
			req.getRequestDispatcher("FetchRailwayRecord.jsp").include(req, resp);;
		}
		
	}
}
