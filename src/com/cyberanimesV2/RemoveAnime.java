package com.cyberanimesV2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete")
public class RemoveAnime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Banco banco = new Banco();

	@Override
	protected void service(HttpServletRequest reg, HttpServletResponse resp) throws IOException {
		String nomeAnime = reg.getParameter("nome");
		
		PrintWriter out = resp.getWriter();

		if (nomeAnime != "") {
			banco.deletaAnime(reg.getParameter("nome"));
			out.println("<html><body>Anime removido com sucesso!</body></html>");
		} else {
			out.println("<html><body>Algo de errado nao esta certo!</body></html>");
		}
		banco.close();
		
		resp.sendRedirect("lista");

	}
}
