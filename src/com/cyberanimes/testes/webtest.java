package com.cyberanimes.testes;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class webtest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SQLiteJDBCDriverConnection banco = new SQLiteJDBCDriverConnection();

	@Override
	protected void service(HttpServletRequest reg, HttpServletResponse resp) throws IOException {
		banco.connect(reg.getParameter("nome"),reg.getParameter("link"),reg.getParameter("img"));
	}
}
