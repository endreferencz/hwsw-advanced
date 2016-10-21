package com.epam.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet.
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	private Cookie getCartCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("cart")) {
				return cookie;
			}
		}
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cartCookie = getCartCookie(request);
		if (cartCookie != null) {
			if (request.getParameter("delete") != null) {
				cartCookie.setMaxAge(0);
				response.addCookie(cartCookie);
			} else {
				String cookieString = cartCookie.getValue();
				String[] cartElements = cookieString.split(",");
				request.setAttribute("cart", cartElements);
			}
		}
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newElement = req.getParameter("element");
		Cookie cartCookie = getCartCookie(req);
		if (cartCookie == null) {
			cartCookie = new Cookie("cart", newElement);
		} else {
			String currentCookieString = cartCookie.getValue();
			List<String> currentElements = new ArrayList<>(Arrays.asList(currentCookieString.split(",")));
			currentElements.add(newElement);
			StringBuilder newCookieStringBuilder = new StringBuilder();
			for (Iterator<String> iter = currentElements.iterator(); iter.hasNext();) {
				String element = iter.next();
				newCookieStringBuilder.append(element);
				if (iter.hasNext()) {
					newCookieStringBuilder.append(",");
				}
			}
			cartCookie.setValue(newCookieStringBuilder.toString());
		}
		resp.addCookie(cartCookie);
		resp.sendRedirect("cart");
	}

}
