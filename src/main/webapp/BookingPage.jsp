<%@page import="dao.Train_dao"%>
<%@page import="dto.Trains"%>
<%@page import="dto.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Users users=(Users)session.getAttribute("users");%>
	<%if(users==null){ 
	response.getWriter().print("<h1>Session Expired</h1>");
	request.getRequestDispatcher("Login.html");
	}else{
		
	int trainnumber=Integer.parseInt(request.getParameter("tno"));
	Train_dao dao=Train_dao.getInstance();
	Trains trains=dao.fetch(trainnumber);
	if(trains==null){
		response.getWriter().print("<h1>there is no train</h1>");
		request.getRequestDispatcher("CustomerHome.html");
	}else{
	
	%>
	
		<h1>Hello,<%=users.getFirst_name()+" "+users.getLast_name() %></h1>
	<form action="bookticket" method="post">
		userId:<input type="text" name="id"value="<%=users.getId()%>" readonly="readonly">
		Train Number:<input type="text" name="tno" value="<%=trains.getNumber()%>"> 
		from:<select name="from">
			<%for(int i=0;i<trains.getStations().length-1;i++){ %>
			<option><%=trains.getStations()[i] %></option>
			<%} %>
		</select>
		to:<select name="to">
			<%for(int i=1;i<trains.getStations().length-1;i++){ %>
			<option><%=trains.getStations()[i] %></option>
			<%} %>
		</select>
		Date of Jorney:<input type="date" name="doj">
		Number of Seat:<input type="number"name="seat">
		
		<button >book</button>
		
	<%} }%>
	
	<button href="CustomerHome.jsp">Back</button>
	
	</form>
</body>
</html>