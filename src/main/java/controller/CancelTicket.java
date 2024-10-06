package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Train_dao;
import dao.Users_dao;
import dto.BookTicket;
import dto.Trains;
import dto.Users;
@WebServlet("/cancelticket")
public class CancelTicket extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users users=(Users)req.getSession().getAttribute("users");
		if(users==null){
			resp.getWriter().print("<h1 style='color:red'>Session Expired Login Again</h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
		}else{
			int pnr=Integer.parseInt(req.getParameter("pnr"));
			Train_dao dao=Train_dao.getInstance();
			BookTicket ticket= dao.fetchTicket(pnr);
			if(ticket==null){
				resp.getWriter().print("<h1 style='color:red'>Invalid PNR Number</h1>");
				req.getRequestDispatcher("CustomerHome.html").include(req, resp);
			}else{
				if(Period.between(LocalDate.now(),ticket.getDateOfJourney().toLocalDate()).getDays()<=0){
					resp.getWriter().print("<h1 style='color:red'>You can not cancel this ticket</h1>");
					req.getRequestDispatcher("CustomerHome.html").include(req, resp);
				}else{
					ticket.setStatus("Cancelled");
					Trains trains=dao.fetch(ticket.getTrainNumber());
					trains.setSeats(trains.getSeats()+ticket.getNumberOfSeats());
					
					users.setWallet(users.getWallet()+ticket.getAmount());
					Users_dao dao2=Users_dao.getInstance();
					dao2.update(users);
					dao.update(trains);
					dao.updateTicket(ticket);
					
					resp.getWriter().print("<h1>Ticket Cancelled Successfull</h1>");
					req.getRequestDispatcher("CustomerHome.html").include(req, resp);
				}
			}
		}
	}
	
}
