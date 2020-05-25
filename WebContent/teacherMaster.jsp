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
<h3 style = "text-decoration underline;">WELCOME TO TEACHER MASTER</h3>
<% if (session.getAttribute("userid")!=null){%>
<h3>Please Select Action</h3>
<form action="">
Menu List<select name = "teacherMasterMenu">
<option value = "">Select</option>
<option value = "AddTeacher">AddTeacher</option>
<option value = "ListSTeacherInClass">ListTeacherInClass</option>
<option value = "UpdateTeacherSubject">UpdateTeacherSubject</option>
</select></br>

<input type ="submit" name= "click" value= "FetchReport">
</form>
		
		<%if(request.getParameter("click")!=null) {
			String teacherMasterMenu=request.getParameter("teacherMasterMenu");
			if (teacherMasterMenu !=null){
				if (teacherMasterMenu.equals("AddTeacher")){%>
			<% response.sendRedirect("addTeacher.jsp");%>
				<%}else if(teacherMasterMenu.equals("ListSTeacherInClass")){%>
			<% response.sendRedirect("listTeacher.jsp");%>
			<%}else if(teacherMasterMenu.equals("UpdateTeacherSubject")){%>
			<% response.sendRedirect("updateTeacherSubject.jsp");%>
					
				<%}
		}else{
		out.print("<p style='color:red;'>Please select Admin Menu option</p> ");
	}
		}
		
}else{
		response.sendRedirect("success.jsp");
	}%>
</body>
</html>