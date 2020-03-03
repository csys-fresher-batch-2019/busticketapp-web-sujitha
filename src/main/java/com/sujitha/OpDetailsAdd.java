package com.sujitha;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujitha.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.sujitha.busticketapp.model.OperatorsDetails;


public class OpDetailsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		OperatorsDetails o=new OperatorsDetails();
		o.setOperatorName(request.getParameter("name"));
	o.setOperatorEmailId(request.getParameter("email"));
	o.setOperatorPhoneNumber(request.getParameter("number"));
	o.setOperatorPassword(request.getParameter("password"));
		try {
			od.setDetails(o);
			RequestDispatcher dispatcher = request.getRequestDispatcher("aaa.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}

	


