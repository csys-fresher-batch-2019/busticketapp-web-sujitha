package com.sujitha;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sujitha.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.sujitha.busticketapp.dto.Buses;


public class BusName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatorsDetailsDAOImpl od=new OperatorsDetailsDAOImpl();
		Buses b = new Buses();
		HttpSession sess = request.getSession();
		//int route=(Integer)sess.getAttribute("route_no");
       b.setBusName(request.getParameter("busname"));
		try {
			List<Buses> list = new ArrayList<Buses>();
          list=od.displayBusDetails(b.getBusName());
			request.setAttribute("BusName_list", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("BusName.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	

}
