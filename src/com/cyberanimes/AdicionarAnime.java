package com.cyberanimes;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add")
public class AdicionarAnime extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	HttpClientStatus banco2 = null;
	HttpClientStatus add = new HttpClientStatus();
	@Override
	protected void service(HttpServletRequest reg, HttpServletResponse resp) throws IOException {
		String nome = reg.getParameter("nome");
//		banco2 = new HttpClientStatus();
		PrintWriter out = resp.getWriter();
		
		
		add.adicionar(nome);
		
		
		
//		if (nome != "") {
//			System.out.println(nome);
//			banco2.adicionar("https://yayanimes.net/hack-roots/");
//			
//			out.println("<html><body>Anime adicionado com sucesso!</body></html>");
//		}else {
//			out.println("<html><body>Algo de errado nao esta certo!</body></html>");
//		}
	}
}

