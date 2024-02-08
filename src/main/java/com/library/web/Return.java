package com.library.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.BookDAO;
import com.library.util.Util;

@WebServlet("/return")
public class Return extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public Return() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String mid = (String) session.getAttribute("mid");
    BookDAO dao = new BookDAO();

    for (String s : request.getParameterValues("rtno")) {
      dao.bookReturn(Util.str2Int(s), mid);
    }
    response.sendRedirect("/info");
  }
}
