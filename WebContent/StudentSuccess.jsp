<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session!=null && session.getAttribute("studentNew")!=null) {%>
	<span style="color:green;">Product Added Successfully with details<%=session.getAttribute("studentNew") %></span>
	<%
	session.removeAttribute("studentNew");
	} %>
	<%if(session!=null && session.getAttribute("error")!=null) {%>
	<span style="color:red;">Error from Server<%=session.getAttribute("error") %></span>
	<%}session.removeAttribute("error"); %>
</body>
</html>