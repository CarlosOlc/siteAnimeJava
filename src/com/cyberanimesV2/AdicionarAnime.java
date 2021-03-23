package com.cyberanimesV2;

import java.io.IOException;
import java.net.MalformedURLException;

import com.cyberanimes.testes.testeThread;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AdicionarAnime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("nome");
		String url = request.getQueryString();
		System.out.println("URL: " + url);
		System.out.println(link);
		new AdicionarAnimeEpisodes(link);
		response.sendRedirect("lista");
	}

}
