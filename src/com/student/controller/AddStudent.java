package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.exception.BusinessException;
import com.student.bo.studentBO;
import com.student.boimpl.StudentBOImpl;
import com.student.model.Student;
import com.sun.xml.internal.ws.resources.HttpserverMessages;

/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session= request.getSession();
//		Student student=(Student) session.getAttribute("student");
		studentBO studentBO =new StudentBOImpl();
		
		Student student=new Student();
		student.setFname(request.getParameter("fname"));
		student.setLname(request.getParameter("lname"));
		student.setCid(Integer.parseInt(request.getParameter("cid")));
//		out.print("<h3> Hello "+ student.getFname()+ " Confirm your details below</h3>");
//		out.print("h4>"+ student+"</h4>");
		System.out.println("Sesion id= " + session.getId());
		try {
			
			student=studentBO.addStudent(student);
			System.out.println("Student Created "+ student);
//			if(student.getCid()!=0) {
				session.setAttribute("studentNew", student);
				response.sendRedirect("StudentSuccess.jsp");
//				out.print(student);
		
//			}
		}catch (BusinessException e) {
			request.getRequestDispatcher("addStudent.jsp").include(request, response);
			session.setAttribute("error", e.getMessage());
			response.sendRedirect("StudentSuccess.jsp");
		}
		
	}

}
