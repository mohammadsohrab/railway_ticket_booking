package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

@WebServlet("/bookticket")
public class BookTickets extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users users=(Users)req.getSession().getAttribute("users");
		if(users==null){
			resp.getWriter().print("<h1 style='color:red'>Session Expired Login Again</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}else{
			int trainnumber=Integer.parseInt(req.getParameter("tno"));
			Train_dao dao=Train_dao.getInstance();
			Trains trains=dao.fetch(trainnumber);
			String from=req.getParameter("from");
			String to = req.getParameter("to");
			Date doj =  Date.valueOf(req.getParameter("doj"));
			Date dob = Date.valueOf(LocalDate.now());
			int numberOfseat = Integer.parseInt(req.getParameter("seat"));
			if(numberOfseat<=0){
				resp.getWriter().print("<h1 style='color:red'>Enter right no. of seats..</h1>");
				req.getRequestDispatcher("CustomerHome.html").include(req, resp);
			}else{
				if(from.equals(to)){
					resp.getWriter().print("<h1 style='color:red'>select correct destination...</h1>");
					req.getRequestDispatcher("CustomerHome.html").include(req, resp);
				}else{
					int frompos=0;
					int topos=0;
					for (int i = 0; i <trains.getStations().length; i++) {
						if(from.equals(trains.getStations()[i]))
							frompos=i;
						if(to.equals(trains.getStations()[i]))
							topos=i;
					}
					if(frompos>topos){
						resp.getWriter().print("<h1 style='color:red'>select correct destination...</h1>");
						req.getRequestDispatcher("CustomerHome.html").include(req, resp);
					}else{
						double price= Double.parseDouble(trains.getPrice()[topos])-Double.parseDouble(trains.getPrice()[frompos]);
						double amount= price*numberOfseat;
						boolean flag = true;
						for (String day : trains.getDays()) {
							if (day.equalsIgnoreCase(
									doj.toLocalDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH))) {
								flag = false;
							}
						}
						if(Period.between(dob.toLocalDate(), doj.toLocalDate()).getDays()<0 || flag){
							resp.getWriter().print("<h1 style='color:red'>Train Not Available in the selected date</h1>");
							req.getRequestDispatcher("CustomerHome.html").include(req, resp);
						}else{
							if(users.getWallet()<amount){
								resp.getWriter().print("<h1 style='color:red'>You don't have sufficient balance in your Wallet...</h1>");
								req.getRequestDispatcher("CustomerHome.html").include(req, resp);
							}else{
								if(numberOfseat>trains.getSeats()){
									resp.getWriter().print("<h1 style='color:red'>seats Not Available..</h1>");
									req.getRequestDispatcher("CustomerHome.html").include(req, resp);
								}else{
									BookTicket ticket=new BookTicket();
									ticket.setAmount(amount);
									ticket.setTrainname(trains.getName());
									ticket.setSource(from+" - "+trains.getTime()[frompos]);
									ticket.setDestination(to+" - "+trains.getTime()[topos]);
									ticket.setDateOfBooking(dob);
									ticket.setDateOfJourney(doj);
									ticket.setStatus("Booked");
									ticket.setUsers(users);
									ticket.setNumberOfSeats(numberOfseat);
									ticket.setTrainNumber(trainnumber);
									
									dao.save(ticket);
									trains.setSeats(trains.getSeats()-numberOfseat);
									dao.update(trains);
									
									List<BookTicket> tickets = users.getTickets();
									if (tickets == null) {
										tickets = new ArrayList<BookTicket>();
									}
									tickets.add(ticket);
									users.setTickets(tickets);
									users.setWallet(users.getWallet()-amount);
									Users_dao dao2=Users_dao.getInstance();
									dao2.update(users);
									resp.getWriter().print("<h1 style='color:red'>Ticket booked Successfully..</h1>");
									req.getRequestDispatcher("CustomerHome.html").include(req, resp);
								}
							}
						}
					}
				}
			}
		}
	}
}
