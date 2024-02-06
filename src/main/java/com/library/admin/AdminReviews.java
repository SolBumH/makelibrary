package com.library.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.ReviewDAO;
import com.library.dto.ReviewDTO;

@WebServlet("/admin/reviews")
public class AdminReviews extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AdminReviews() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute("mgrade") != null && (int)session.getAttribute("mgrade") == 9) {
      ReviewDAO dao = new ReviewDAO();
      ReviewDTO dto = new ReviewDTO();

      RequestDispatcher rd = request.getRequestDispatcher("adminReviews.jsp");
      rd.forward(request, response);
    } else {
      if (session.getAttribute("mid") != null) {
        response.sendRedirect("/index");
      } else {
        response.sendRedirect("/login");
      }
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}
