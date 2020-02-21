package com.sujitha;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujitha.busticketapp.DbException;
import com.sujitha.busticketapp.dao.impl.BookingDetailDAOImpl;
import com.sujitha.busticketapp.dao.impl.BusListDAOImpl;
import com.sujitha.busticketapp.model.Booking;


public class BusBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       Booking b= new Booking();
	       int row=0;
	       BusListDAOImpl bl= new BusListDAOImpl();
	      int UserId= Integer.parseInt(request.getParameter("userid"));
	      b.setUserId(UserId);
	     
	     int BusNumber= Integer.parseInt(request.getParameter("busnumber"));
	      b.setBusNum(BusNumber);
	      int SeatNo= Integer.parseInt(request.getParameter("numberofseats"));
	      b.setSeatNo(SeatNo);
	      String Gender= (request.getParameter("gender"));
	      b.setUserGender(Gender);
	      String Preferences= request.getParameter("preferences");
	      b.setGenderPreference(Preferences);
	     LocalDate BookingDate=LocalDate.parse(request.getParameter("date"));
	      b.setBookedDate(BookingDate);
	      int Amount=Integer.parseInt(request.getParameter("amount"));
	      b.setAmount(Amount);
	      
	      BookingDetailDAOImpl bg = new BookingDetailDAOImpl();
	       try {
	  			row=bg.addUserBookingDetails(b);
	  			if(row==1)
	  			{
	  			response.sendRedirect("ticketsummary.jsp");
	  			}
	  			
	  			} catch (DbException e) {
	  						e.printStackTrace();
	  		}
	      
	    
	    
	     if(row==0)
	     {
	    	 try {
				bg.bookUnfilledSeats(b);
				response.sendRedirect("ticketsummary.jsp");
			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
	     
	     
	}

}
