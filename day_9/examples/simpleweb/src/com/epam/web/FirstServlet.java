package com.epam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Hello from first servlet");
		
		request.setAttribute("requestAttribute", "VALUE");
		request.getSession().setAttribute("sessionAttribute", "VALUE");
		request.getServletContext().setAttribute("contextAttribute", "VALUE");
	}

}
