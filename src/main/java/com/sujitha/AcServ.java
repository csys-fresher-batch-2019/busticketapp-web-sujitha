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
import com.sujitha.busticketapp.dto.Buses;

/**
 * Servlet implementation class Ac
 */
public class AcServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatorsDetailsDAOImpl od=new OperatorsDetailsDAOImpl();
		List<Buses> list = null;

		Buses b = new Buses();
		 b.setBusModel(request.getParameter("ac"));
		 System.out.println(b);
		try {
			list = od.dispalyBus(b.getBusModel());
			System.out.println(list);
			request.setAttribute("ac_list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Ac.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
