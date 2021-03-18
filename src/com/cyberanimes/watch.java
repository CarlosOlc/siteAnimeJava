package com.cyberanimes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/watch")
public class watch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest reg, HttpServletResponse resp) throws IOException {
		AcoesBanco banco = new AcoesBanco();
		PrintWriter out = resp.getWriter();
		String nome = reg.getParameter("anime");
		ResultSet resultSet = banco.getEp(nome);
		System.out.println(nome);
		try {
			while (resultSet.next()) {
				out.println("<html>	<body style="+"background-color:black;"+"> "
			            + "<a href='"+ "play?link="+resultSet.getString("url_ep")+ "'>"
						+ "<img src=" + resultSet.getString("img_ep") + "> "
						+ "</body></html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}