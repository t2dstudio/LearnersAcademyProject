<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login JSP Page</title>
</head>
<body>
<div align="center">
<h3 style = "text-decoration underline;">Admin Login</h3>
<form action="login" method="post">
<table border="1px">
<tr>
<td><input type ="text" name = "userid" placeholder="ENTER USERID"></td>
<tr>
<tr>
<td><input type ="password" name = "password" placeholder="ENTER PASSWORD"></td>
<tr>
<tr>
<td><input type ="submit" value = "login" ></td>
<tr>
</table>
</form>
<%if(request.getAttribute("errorMessage")!=null){%>
	<span style ="color:red;"><%=request.getAttribute("errorMessage")%> </span>
<%
request.removeAttribute("errorMessage");
}
%>
</div>
</body>
</html>