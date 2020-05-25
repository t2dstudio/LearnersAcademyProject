<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<% if (session.getAttribute("userid")!=null){%>
<h3>hello <%=session.getAttribute("userid") %>.......</h3>
<h3>You have logged in successfully at <%=new SimpleDateFormat("dd.MM.yyyy EEE HH:mm:ss").format(new Date(session.getCreationTime())) %></h3>
<h3>Menu Option</h3>
<form action="">
Menu List<select name = "adminMenu">
<option value = "">Select</option>
<option value = "StudentReport">StudentReport</option>
<option value = "TeacherReport">TeacherReport</option>
<option value = "ClassReport">ClassReport</option>
</select></br>

<input type ="submit" name= "click" value= "FetchReport">
</form>
		<%if(request.getParameter("click")!=null) {
			String adminMenu=request.getParameter("adminMenu");
			if (adminMenu !=null){
				if (adminMenu.equals("StudentReport")){%>
			<% response.sendRedirect("studentMaster.jsp");%>
				<%}else if(adminMenu.equals("TeacherReport")){%>
			<% response.sendRedirect("teacherMaster.jsp");%>
				<%}else if (adminMenu.equals("ClassReport")){%>
		<% response.sendRedirect("subjectMaster.jsp");%>
			
				<%}
		
		}else{
		out.print("<p style='color:red;'>Please select Admin Menu option</p> ");
		}
}
		%>

<a href="logout">Logout</a>
<%}else{	
	response.sendRedirect("login.jsp");
}
         %>
</body>
</html>