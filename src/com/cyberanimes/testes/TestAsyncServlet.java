package com.cyberanimes.testes;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Asynchronous servlet

@WebServlet(urlPatterns = "/asyncServlet", asyncSupported = true)
public class TestAsyncServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {

    final long startTime = System.nanoTime();
    final AsyncContext asyncContext = request.startAsync(request, response);

    new Thread() {

      @Override
      public void run() {
        try {
          ServletResponse response = asyncContext.getResponse();
          response.setContentType("text/plain");
          PrintWriter out = response.getWriter();
          Thread.sleep(2000);
          out.print("Work completed. Time elapsed: " + (System.nanoTime() - startTime));
          out.flush();
          asyncContext.complete();
        } catch (IOException | InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }.start();

  }

}