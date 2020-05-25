package com.teacher.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.exception.BusinessException;
import com.student.model.Student;
import com.teacher.bo.TeacherBO;
import com.teacher.boimpl.TeacherBoImpl;
import com.teacher.model.Teacher;

/**
 * Servlet implementation class listTeacherBySubject
 */
public class listTeacherBySubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listTeacherBySubject() {
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
		teacher.setScode(Integer.parseInt(request.getParameter("scode")));
		TeacherBO teacherBO=new TeacherBoImpl();
		
		try {
			if(teacherBO.listOfTeachers(teacher.getScode())!=null) {
				session.setAttribute("empid", teacherBO.listOfTeachers(teacher.getScode()));
				List<Teacher> teacher1=(List<Teacher>) session.getAttribute("empid");
				out.println("<div>"+ "Please see below details for Subject Teachers "+ "<div>");
				for(Teacher ts: teacher1 ) {
					out.println("<div>" + "Subject Code: "+ ts.getScode()+"</div>");
					out.println("<div>" + "Emplyee Id: "+ ts.getEmpid()+"</div>");
					out.println("<div>" + "First Name: "+ ts.getFname()+"</div>");
					out.println("<div>" + "First Name: "+ ts.getLname()+"</div>");
				}
			}
			
		}catch (BusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
		}
	
		
	}

}
