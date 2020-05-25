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
<h3 style = "text-decoration underline;">Welcome to TeacherMaster Page</h3>
<form action="addTeacher" method="post">
<table border="1px">
<tr>
<td><input type ="text" name = "scode" placeholder="ENTER SUBJECT CODE"></td>
<tr>
<tr>
<td><input type ="text" name = "fname" placeholder="ENTER FIRSTNAME"></td>
<tr>
<tr>
<td><input type ="text" name = "lname" placeholder="ENTER LASTNAME"></td>
<tr>
<tr>
<td><input type ="submit" value = "Create" name = "addTeacher" ></td>
<tr>
</table>
</form>
<%if(request.getParameter("addTeacher")!=null){%>
<jsp:useBean id="teacher" class="com.teacher.model.Teacher" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="teacher"/>
<%
response.sendRedirect("addTeacher");
}
%>
</body>
</html>