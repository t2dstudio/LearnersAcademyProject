<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3 style = "text-decoration underline;">Welcome New Student</h3>
<form action="addStudent" method="post">
<table border="1px">
<tr>
<td><input type ="text" name = "fname" placeholder="ENTER FIRSTNAME"></td>
<tr>
<tr>
<td><input type ="text" name = "lname" placeholder="ENTER LASTNAME"></td>
<tr>
<tr>
<td><input type ="text" name = "cid" placeholder="ENTER COURSE ID"></td>
<tr>
<tr>
<td><input type ="submit" value = "Create" name = "addStudent" ></td>
<tr>
</table>
</form>
<%if(request.getParameter("addStudent")!=null){%>
<jsp:useBean id="student" class="com.student.model.Student" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="student"/>
<%
response.sendRedirect("addStudent");
}
{%>

<%= ("Please Enter valid credentilas")%>

<% }
%>
<%if(request.getAttribute("errorMessage")!=null){%>
	<span style ="color:red;"><%=request.getAttribute("errorMessage")%> </span>
<%
request.removeAttribute("errorMessage");
}
//%>
</div>
</body>
</html>