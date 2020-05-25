package com.student.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.login.exception.BusinessException;
import com.student.bo.studentBO;
import com.student.boimpl.StudentBOImpl;
import com.student.daolimpl.StudentDAOImpl;
import com.student.model.Student;

/**
 * Servlet implementation class ListStudentsInClass
 */
public class ListStudentsInClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudentsInClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Student student=new Student();
		student.setCid(Integer.parseInt(request.getParameter("cid")));
		studentBO studentBO =new StudentBOImpl();
//		StudentDAOImpl std = new StudentDAOImpl();
		
//		if(session ==null) {
//			out.print("Please login first");
//		}else {
		
		try {
			
				if(studentBO.listOfStudentbyCourse(student.getCid())!=null) {
					session.setAttribute("userid", (studentBO.listOfStudentbyCourse(student.getCid())));
					List<Student> student1=(List<Student>) session.getAttribute("userid");
					out.println("<div>"+ "Please see below details for Class ID "+ "<div>");
					for (Student v:student1) {		
					out.println("<div>" + "First Name: "+ v.getFname()+"</div>");
					out.println("<div>" + "Last Name: "+ v.getLname()+"</div>");
					out.println("<div>" + "Class ID: "+ v.getCid()+ "<div>");
					out.println("<div>" + "Student ID: "+v.getStid());
	
//					response.sendRedirect("StudentSuccess.jsp");
					}
				}
			
		} catch (BusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
		}
		
	}

}
