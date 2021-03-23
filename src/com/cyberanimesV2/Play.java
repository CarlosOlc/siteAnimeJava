package com.cyberanimesV2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		String url = request.getQueryString();
		url = url.replace("link=", "");
		String version = request.getParameter("version");
		RequestDispatcher rd = null;
		if(version.equals("1")) {
			url = url.replace("&version=1", "");
			rd = request.getRequestDispatcher("/player2.jsp");
		}else {
			url = url.replace("&version=2", "");
			rd = request.getRequestDispatcher("/player1.jsp");
		}
		request.setAttribute("link", url);
		rd.forward(request, response);
		
//		Banco banco = new Banco();
//		String idAtual = banco.getIdUrl(url);
//		System.out.println(idAtual);
		
	}
}

