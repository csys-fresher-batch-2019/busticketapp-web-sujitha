package com.sujitha;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sujitha.busticketapp.dao.impl.UserDetailsDAOImpl;
import com.sujitha.busticketapp.logger.Logger;
import com.sujitha.busticketapp.model.UserDetails;

public class LoginDetails extends HttpServlet {
	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetails ud = new UserDetails();
		ud.setUserPhnNum(Long.parseLong(request.getParameter("phonenumber")));
		ud.setPassword(request.getParameter("password"));
		UserDetailsDAOImpl udi = new UserDetailsDAOImpl();
		PrintWriter out = response.getWriter();
		try {
			int uid = udi.getUserId(ud.getUserPhnNum(), ud.getPassword());
			out.print(uid);
			if (uid != 0) {

				HttpSession sess = request.getSession();
				sess.setAttribute("userid", uid);
				response.sendRedirect("Routes.jsp");
			}

			else {
				response.sendRedirect("Login.jsp?errorMessage=Invalid Username or Password");
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

}
