package com.sujitha;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sujitha.busticketapp.dao.impl.TicketBookingDAOImpl;
import com.sujitha.busticketapp.logger.Logger;
import com.sujitha.busticketapp.model.Booking;

public class DisplayBookedUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log=Logger.getInstance(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketBookingDAOImpl tbi=new TicketBookingDAOImpl();
		 List<Booking> list=new ArrayList<Booking>();
		 Booking b= new Booking();
		
		HttpSession sess=request.getSession();
		
	     Integer userId = (Integer) sess.getAttribute("userid");
	     Integer amount=(Integer)sess.getAttribute("amount");
	     PrintWriter out = response.getWriter();
		out.println(userId);
	     try {
			list=tbi.bookedUserDetails(userId);
			out.println("TicketS:" + list);
			request.setAttribute("users_display", list);
		    RequestDispatcher dispatcher=request.getRequestDispatcher("BookingUsersDisplay.jsp");
           dispatcher.forward(request, response);
			
		} catch (Exception e) {
						e.printStackTrace();
		}
	       
	    	   
		}
	      		       
	       
	
	
	
	
	}

	

