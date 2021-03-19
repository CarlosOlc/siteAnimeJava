package com.cyberanimesV2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/watch")
public class watch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Banco banco = new Banco();
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("anime");
		ResultSet resultSet = banco.getEp(nome);
		System.out.println(nome);
		try {
			while (resultSet.next()) {
				String url = resultSet.getString("url_ep");
				System.out.println("URL: "+ url);
				
				out.println("<html>	<body style="+"background-color:black;"+"> "
			            + "<a href='"+ "play?link=\""+resultSet.getString("url_ep")+"\"&version="+resultSet.getString("version") +"'>"
						+ "<img src=" + resultSet.getString("img_ep") + "> "
						+ "</body></html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}