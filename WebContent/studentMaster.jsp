<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Master</title>
</head>
<body>
<div align="center">
<h3 style = "text-decoration underline;">WELCOME TO STUDENT MASTER</h3>
<% if (session.getAttribute("userid")!=null){%>
<h3>Please Select Action</h3>
<form action="">
Menu List<select name = "studentMasterMenu">
<option value = "">Select</option>
<option value = "AddStudent">AddStudent</option>
<option value = "ListStudentInClass">ListStudentInClass</option>

</select></br>

<input type ="submit" name= "click" value= "FetchReport">
</form>
		
		<%if(request.getParameter("click")!=null) {
			String studentMasterMenu=request.getParameter("studentMasterMenu");
			if (studentMasterMenu !=null){
				if (studentMasterMenu.equals("AddStudent")){%>
			<% response.sendRedirect("addStudent.jsp");%>
				<%}else if(studentMasterMenu.equals("ListStudentInClass")){%>
			<% response.sendRedirect("listStudent.jsp");%>
			
					
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