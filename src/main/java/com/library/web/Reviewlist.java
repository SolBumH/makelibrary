package com.library.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.ReviewDAO;

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

      // 클라이언트로부터 전달된 데이터 받기
      String title = request.getParameter("title_give");
      String author = request.getParameter("author_give");
      String reviewContent = request.getParameter("review_give");

      // 받은 데이터를 데이터베이스에 저장
      ReviewDAO reviewDAO = new ReviewDAO();
      reviewDAO.addReview(title, author, reviewContent);

      // 클라이언트로 응답 보내기
      PrintWriter out = response.getWriter();
      out.print("{\"msg\": \"리뷰가 성공적으로 저장되었습니다.\"}");
      out.flush();
  }
}
