package com.sujitha;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujitha.busticketapp.DbException;
import com.sujitha.busticketapp.dao.impl.BusListDAOImpl;
import com.sujitha.busticketapp.dao.impl.BusRoutesDAOImpl;
import com.sujitha.busticketapp.dto.BusesDetails;
import com.sujitha.busticketapp.logger.Logger;



public class DisplayBusList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String from = request.getParameter("FromLocation");
		String to = request.getParameter("ToLocation");
		
		System.out.println("Display:" + from + "-" + to);
		BusRoutesDAOImpl bi= new BusRoutesDAOImpl();
		
	try {
		int routeNo = bi.getRouteNo(from, to );
		System.out.println("routeNo: "+ routeNo);
		BusListDAOImpl bli = new BusListDAOImpl();
		List<BusesDetails> list1=new ArrayList<BusesDetails>();
		list1=bli.allBusListDetails(routeNo);
	    
		request.setAttribute("Bus_list", list1);
			System.out.println(list1);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("BusListDisplay.jsp");
            dispatcher.forward(request, response);
		} catch (DbException e) {

			e.printStackTrace();

		}

	}

}
