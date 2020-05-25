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
 * Servlet implementation class updateTeacher
 */
public class updateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateTeacher() {
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
		Teacher teacher=new Teacher();
		int scode=Integer.parseInt(request.getParameter("scode"));
		int empid=Integer.parseInt(request.getParameter("empid"));
		
		TeacherBO teacherBO=new TeacherBoImpl();
		
		try {
		teacherBO.updateTeacherBySubjectCode(scode, empid);
				
		}catch (BusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
	}
	}
}
