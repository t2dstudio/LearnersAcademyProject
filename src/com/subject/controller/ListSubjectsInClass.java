package com.subject.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.subject.daoimpl.*;
import com.login.exception.BusinessException;
import com.subject.bo.subjectBO;
import com.subject.boimpl.SubjectBOImpl;
import com.subject.model.Subject;

/**
 * Servlet implementation class ListSubjectsInClass
 */
public class ListSubjectsInClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSubjectsInClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am here");
		response.setContentType("text/html");;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Subject subject=new Subject();
		subject.setCid(Integer.parseInt(request.getParameter("cid")));
		subjectBO subjectBO=new SubjectBOImpl();
		System.out.println(subject.getCid());
		try {
			
			if(subjectBO.listSubjectsByClass(subject.getCid())!=null);
			System.out.println("I WAS HER");
			session.setAttribute("userid", subjectBO.listSubjectsByClass(subject.getCid()));
			List<Subject> subjectList=(List<Subject>)session.getAttribute("userid");
			out.println("<div>"+ "Please see below List of Subjects in Class ID "+ "<div>");
			for(Subject st: subjectList) {
				out.print("<div>"+ "Class ID: "+ st.getCid()+ "</div>");
				out.print("<div>"+ "Subject Code: "+ st.getScode()+ "</div>");
				out.print("<div>"+ "Subject Name: "+ st.getSname()+ "</div>");
		
			}
		} catch (BusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
		}
	}

}
