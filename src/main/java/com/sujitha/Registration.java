package com.sujitha;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujitha.busticketapp.dao.impl.UserDetailsDAOImpl;
import com.sujitha.busticketapp.logger.Logger;
import com.sujitha.busticketapp.model.UserDetails;


public class Registration extends HttpServlet {
	private static final Logger log=Logger.getInstance(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserDetails ud = new UserDetails();
	ud.setUserName(request.getParameter("name"));
	ud.setUserGender(request.getParameter("gender"));
	ud.setUserPhnNum(Long.parseLong(request.getParameter("mobileno")));
	ud.setPassword(request.getParameter("password"));
	UserDetailsDAOImpl udi= new	UserDetailsDAOImpl();
	try {
		udi.getUserDetails(ud.getUserName(), ud.getUserPhnNum(), ud.getUserGender(), ud.getPassword());
		response.sendRedirect("Login.jsp");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error(e);
	}
	}

	
	
}
