package com.cyberanimes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/lista")
public class ListaAnimes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest reg, HttpServletResponse resp) throws IOException {
		AcoesBanco banco = new AcoesBanco();
		PrintWriter out = resp.getWriter();
		ResultSet resultSet = banco.getAnimes();
		try {
			while (resultSet.next()) {
				out.println("<html>	<body style="+"background-color:black;"+"> "
                        + "<a href='"+ "watch?anime="+resultSet.getString("name_anime")+ "'>"
						+ "<img src=" + resultSet.getString("img_anime") + "> "
						+ "</body></html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		
		
		banco.close();
	}

}
