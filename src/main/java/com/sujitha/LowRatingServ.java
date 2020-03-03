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

public class LowRatingServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatorsDetailsDAOImpl od=new OperatorsDetailsDAOImpl();
		Buses b = new Buses();
		
		try {
			List<Buses> list = new ArrayList<Buses>();
			list=od.displayBusesRating();
			System.out.println(list);
			request.setAttribute("low", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("LowRating.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
