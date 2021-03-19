package com.cyberanimesV2;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/play")
public class Play extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Request"+ request.getParameter("link"));
		String link = request.getParameter("link");
		String version = request.getParameter("version");
		link = link.replaceAll("\"", "");
		System.out.println(link);
		RequestDispatcher rd = null;
		request.setAttribute("link", link);
		if(version.equals("1")) {
			rd = request.getRequestDispatcher("/player2.jsp");
		}else {
			rd = request.getRequestDispatcher("/player1.jsp");
		}
		rd.forward(request, response);
	}
}

