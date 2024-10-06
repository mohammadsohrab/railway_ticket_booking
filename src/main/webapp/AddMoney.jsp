<%@page import="dto.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Money</title>
</head>
<body>
<%Users users=(Users)session.getAttribute("users"); %>
<%if(users==null){
	out.print("<h1>Session Expired Login first..</h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}
else{
%>
<form action="addmoney">
<h1>Add Money</h1><br>
<tr>
<th>Enter amount:</th>
<td><input type="number" name="amount"></td>
</tr>
<tr>
<th><a href="CustomerHome.jsp"><button>Back</button></a></th>
<th><button>Add</button></th>
</tr>
<%} %>

</form>
</body>
</html>