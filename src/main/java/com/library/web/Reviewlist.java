package com.library.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewlist")
public class Reviewlist extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Reviewlist() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    String sampleReceive = request.getParameter("sample_give");
    System.out.println(sampleReceive);

    PrintWriter out = response.getWriter();
    out.print("{\"msg\": \"이 요청은 GET!\"}");
    out.flush();
    // JSP 페이지로 포워딩
    RequestDispatcher rd = request.getRequestDispatcher("bookreview.jsp");
    rd.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    String sampleReceive = request.getParameter("sample_give");
    System.out.println(sampleReceive);

    PrintWriter out = response.getWriter();
    out.print("{\"msg\": \"이 요청은 POST!\"}");
    out.flush();
  }
}
