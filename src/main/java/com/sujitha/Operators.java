package com.sujitha;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujitha.busticketapp.logger.Logger;
import com.sujitha.busticketapp.model.OperatorsDetails;
import com.sujitha.busticketapp.dao.impl.OperatorsDetailsDAOImpl;

public class Operators extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getInstance();

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatorsDetailsDAOImpl o=new OperatorsDetailsDAOImpl();
		OperatorsDetails od=new OperatorsDetails();
		od.setOperatorEmailId(request.getParameter("email"));
		od.setOperatorPassword(request.getParameter("password"));
		int id=o.getId(od.getOperatorEmailId(),od.getOperatorPassword());
		if (id!=0) {
			response.sendRedirect("OperatorsDetails.jsp");
		}else {
			response.sendRedirect("Operators.jsp?errorMessage=Invalid Username or Password");

		}
}
}