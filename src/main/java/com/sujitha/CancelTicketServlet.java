package com.sujitha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujitha.busticketapp.dao.BookingDeatilsDAO;
import com.sujitha.busticketapp.dao.impl.BookingDetailDAOImpl;



/**
 * Servlet implementation class CancelTicketServlet
 */
public class CancelTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookingId = request.getParameter("bookingId");
		System.out.println(bookingId);
		
		BookingDeatilsDAO bookingDeatilsDAO = new BookingDetailDAOImpl();
	 bookingDeatilsDAO.cancelTicket(bookingId);
		PrintWriter out=response.getWriter();
		out.print("Your Ticeket is successfully cancelled");
	}

}
