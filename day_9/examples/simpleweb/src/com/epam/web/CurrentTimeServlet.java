package com.epam.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentTimeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append(new Date().toString());

		resp.getWriter().append(String.format("REQUEST attribute: %\n", req.getAttribute("requestAttribute")));
		resp.getWriter().append(String.format("SESSION attribute: %\n", req.getSession().getAttribute("sessionAttribute")));
		resp.getWriter().append(String.format("CONTEXT attribute: %\n", getServletContext().getAttribute("contextAttribute")));
	}

}
