package controller;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Train_dao;
import dto.Trains;
@WebServlet("/addTrain")
public class AddTrain extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int tno=Integer.parseInt(req.getParameter("tno"));
		String tname=req.getParameter("tname");
		int seat=Integer.parseInt(req.getParameter("seat"));
		String []stations=req.getParameter("sname").split(",");
		String[]price=req.getParameter("tprice").split(",");
		String []ttime=req.getParameter("ttime").split(",");
		String []tdays=req.getParameter("tday").split(",");
		Trains trains=Trains.getInstance();
		trains.setNumber(tno);
		trains.setName(tname);
		trains.setSeats(seat);
		trains.setStations(stations);
		trains.setTime(ttime);
		trains.setPrice(price);
		trains.setDays(tdays);
		Train_dao dao=Train_dao.getInstance();
		dao.save(trains);
		//resp.getWriter().print("<h6 style='color:green'>***Train Details added successfully</h6>");
		req.getRequestDispatcher("ManagementHome.html").include(req, resp);	
	}
}
