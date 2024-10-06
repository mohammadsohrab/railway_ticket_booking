<%@page import="dto.BookTicket"%>
<%@page import="java.util.List"%>
<%@page import="dto.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Tickets</title>
</head>
<body>
<%Users users=(Users)session.getAttribute("users");%>
<%if(users==null){
	response.getWriter().print("<h1 style='color:red'>Session Expired login again</h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}
else{
	List<BookTicket>tickets=users.getTickets();
	if(tickets.isEmpty()){
		response.getWriter().print("<h1 style='color:red'>No tickets Booked</h1>");
		request.getRequestDispatcher("CustomerHome.html").include(request, response);
	}else{
	
	%>
	<nav>
	<h3>IRCTC</h3>
	<a href="CustomerHome.html"><button>Back</button></a>
	</nav>
	<table border="1">
	<tr>
	<th>PNR number</th>
	<th>Train Name</th>
	<th>Date of Journey</th>
	<th>Date of Booking</th>
	<th>Source & Time</th>
	<th>Destination & Time</th>
	<th>Number of Seats Book</th>
	<th>Amount</th>
	<th>Status</th>
	<th>Cancel Ticket</th>
	</tr>
	<%
	for(BookTicket ticket:tickets){
	%>
	<tr>
	<td><%=ticket.getPnr() %></td>
	<td><%=ticket.getTrainname() %></td>
	<td><%=ticket.getDateOfJourney() %></td>
	<td><%=ticket.getDateOfBooking() %></td>
	<td><%=ticket.getSource() %></td>
	<td><%=ticket.getDestination() %></td>
	<td><%=ticket.getNumberOfSeats() %></td>
	<td><%=ticket.getAmount() %></td>
	<td><%=ticket.getStatus() %></td>
	<%if(ticket.getStatus().equals("Booked")) {%>
	<td><a href="cancelticket?pnr=<%=ticket.getPnr()%>"><button>cancel</button></a></td>
	</tr>
	<%}else{%>
	<td><button>cancel</button></td>
	<%}} %>
	</table>
<%}}

%>
</body>
</html>