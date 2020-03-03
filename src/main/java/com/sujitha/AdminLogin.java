package com.sujitha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujitha.busticketapp.dao.impl.AdminDAOImpl;
import com.sujitha.busticketapp.logger.Logger;
import com.sujitha.busticketapp.model.Admin;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin a = new Admin();
		a.setAdminMailId(request.getParameter("email"));
		a.setAdminPassword(request.getParameter("password"));
		AdminDAOImpl ai = new AdminDAOImpl();
		PrintWriter out = response.getWriter();
try {
		int id =ai.getId(a.getAdminMailId(),a.getAdminPassword());
if (id!=0) {
	response.sendRedirect("aaa.jsp");
		}else {
			response.sendRedirect("Admin.jsp?errorMessage=Invalid Username or Password");

		}
}
catch(Exception e) {
	log.error(e);
}	

}
}
