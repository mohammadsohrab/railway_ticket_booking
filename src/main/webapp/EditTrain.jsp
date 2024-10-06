<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="java.util.Arrays"%>
<%@page import="dto.Trains"%>
<%@page import="dao.Train_dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Train_dao dao=Train_dao.getInstance();
Trains trains=dao.fetch(Integer.parseInt(request.getParameter("trainnumber")));
%>
<h1>Edit Train Details</h1>
<form action="edittrain"method="" >
Train Number:<input type="number" name="tno" value=<%=trains.getNumber()%>><br>
Train name:<input type="text" name="tname" value=<%=trains.getName()%>><br>
Number Of Seats:<input type="number" name="seat"value=<%=trains.getSeats() %>><br>
Station:<textarea rows="5" cols="30" name="sname" ><%=dao.disp(trains.getStations()) %></textarea> <br>
Ticket price:<textarea rows="5" cols="30"name="tprice"><%=dao.disp(trains.getPrice()) %></textarea><br>
Time:<textarea rows="5" cols="30"name="ttime"><%=dao.disp(trains.getTime()) %></textarea><br>
Day:<textarea rows="5" cols="30" name="tday"><%=dao.disp(trains.getDays()) %></textarea><br>
<button type="reset">cancel</button><button type="submit">Update</button><br>
</form>




</body>
</html>