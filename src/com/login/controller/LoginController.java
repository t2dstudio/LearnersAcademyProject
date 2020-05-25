package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.bo.LoginBO;
import com.login.boImpl.LoginBoImpl;
import com.login.exception.BusinessException;
import com.login.model.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		User user=new User();
		user.setUserid(request.getParameter("userid"));
		user.setPassword(request.getParameter("password"));
		
		PrintWriter out = response.getWriter();
		LoginBO loginBO=new LoginBoImpl();
		RequestDispatcher rd=null;
		
		try {
			if(loginBO.isValidUser(user)) {
				HttpSession session=request.getSession();
//				rd=request.getRequestDispatcher("success");
//				rd.forward(request, response);
				session.setAttribute("userid", user.getUserid());
//				response.sendRedirect("success");
				response.sendRedirect("success.jsp");
			}
		}catch (BusinessException e) {
//			rd=request.getRequestDispatcher("login.html");
//			rd.include(request, response);
//			out.print("<center><span style ='color:red'>"+e.getMessage()+"</span><center>");
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
