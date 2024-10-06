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
<% if(users==null){
	response.getWriter().print("Session Expire...");
	request.getRequestDispatcher("Login.html").include(request, response);
}else{
%>
<h1>The Amount is <%=users.getWallet() %></h1>
<a href="CustomerHome.html"><button>back</button></a>
<a href="AddMoney.jsp"><button>Add</button></a>
<%} %>

</body>
</html>