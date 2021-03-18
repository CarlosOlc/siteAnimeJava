package com.cyberanimes;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/new")
public class novoAnime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest reg, HttpServletResponse resp) throws IOException {
		HttpClientStatus add = new HttpClientStatus();
		try {
			add.adicionar("https://yayanimes.net/Kemono-Jihen/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

