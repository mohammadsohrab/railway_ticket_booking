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

@WebServlet("/edittrain")
public class EditTrainDetails extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int number=Integer.parseInt(req.getParameter("tno"));
		String name=req.getParameter("tname");
		int seats=Integer.parseInt(req.getParameter("seat"));
		String[]stations=req.getParameter("sname").split(",");
		String[]price=req.getParameter("tprice").split(",");
		String[]days=req.getParameter("tday").split(",");
		String[]time=req.getParameter("ttime").split(",");
		Train_dao dao=Train_dao.getInstance();
		Trains trains=Trains.getInstance();
		trains.setNumber(number);
		trains.setName(name);
		trains.setSeats(seats);
		trains.setStations(stations);
		trains.setPrice(price);
		trains.setDays(days);
		trains.setTime(time);
		dao.update(trains);
		List<Trains>list=dao.fetchAll();
		resp.getWriter().print("<p style='color:green'>**Details Update successfully!!!</p>");
		req.setAttribute("list", list);
		req.getRequestDispatcher("FetchRailwayRecord.jsp").include(req, resp);
		
		
		
		
		
		
	}
}
