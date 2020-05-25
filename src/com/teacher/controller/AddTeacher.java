package com.teacher.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.exception.BusinessException;
import com.teacher.bo.TeacherBO;
import com.teacher.boimpl.TeacherBoImpl;
import com.teacher.model.Teacher;

/**
 * Servlet implementation class AddTeacher
 */
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() {
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
		TeacherBO teacherBO=new TeacherBoImpl();
		Teacher teacher=new Teacher();
		
		teacher.setScode(Integer.parseInt(request.getParameter("scode")));
		teacher.setFname(request.getParameter("fname"));
		teacher.setLname(request.getParameter("lname"));
		
		try {
			teacher= teacherBO.addTeacher(teacher);
			session.setAttribute("teacherNew", teacher);
			response.sendRedirect("teacherSuccess.jsp");
		
	}catch (BusinessException e) {
		request.getRequestDispatcher("addTeacher.jsp").include(request, response);
		session.setAttribute("error", e.getMessage());
		response.sendRedirect("teacherSuccess.jsp");
	}
	}

}
