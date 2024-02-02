package com.library.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.BookDAO;
import com.library.dto.BookDTO;

@WebServlet("/cart")
public class Cart extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Cart() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    BookDTO dto = new BookDTO();
    BookDAO dao = new BookDAO(); 
    dto.setMid((String)session.getAttribute("mid"));
    
    dto = dao.cartList(dto);
    
    RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
    rd.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}
