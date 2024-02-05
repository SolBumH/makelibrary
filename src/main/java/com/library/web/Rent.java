package com.library.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.BookDAO;

@WebServlet("/rent")
public class Rent extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Rent() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("rent : get");
    
    response.sendRedirect("./cart");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("rent : post");
    BookDAO dao = new BookDAO();
    String[] book = null;
    HttpSession session = request.getSession();
    
    if (request.getParameterValues("book") != null) {
      book = request.getParameterValues("book");
      for(int i = 0; i < book.length; i++) {
        dao.addRent(book[i], (String)session.getAttribute("mid"));
        dao.delCart(book[i], (String)session.getAttribute("mid"));
      }
    }
    response.sendRedirect("./cart");
  }
}
