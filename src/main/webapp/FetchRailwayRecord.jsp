<%@page import="java.util.Arrays"%>
<%@page import="dto.Trains"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Trains> list=(List)request.getAttribute("list"); %>
<table border="1">
<tr>
<td>Train number</td>
<td>Train name</td>
<td>from</td>
<td>to</td>
<td>Seats</td>
<td>Stations</td>
<td>departure</td>
<td>Arrival</td>
<td>price</td>
<td>days</td>
<td>delete</td>
<td>edit</td>
</tr>
<%for(Trains trains:list){ %>
<tr>
<td><%=trains.getNumber() %></td>
<td><%=trains.getName() %></td>
<td><%=trains.getStations()[0] %></td>
<td><%=trains.getStations()[trains.getStations().length-1]%></td>
<td><%=trains.getSeats() %></td>
<td><%=Arrays.toString(trains.getStations())%></td>
<td><%=trains.getTime()[0] %></td>
<td><%=trains.getTime()[trains.getTime().length-1] %></td>
<td><%=trains.getPrice()[trains.getPrice().length-1] %></td>
<td><%=Arrays.toString(trains.getDays()) %></td>
<td><a href="deletetrain?trainnumber=<%=trains.getNumber() %>"><button type="submit">delete</button></a></td>
<td><a href="EditTrain.jsp?trainnumber=<%=trains.getNumber() %>"><button type="submit">edit</button></a></td>
</tr>
<%} %>
</table>


</body>
</html>