package com.library.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.BookDAO;
import com.library.dto.BookDTO;

@WebServlet("/addCart")
public class AddCart extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AddCart() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println(request.getParameterValues("book"));
    System.out.println(request.getParameterValues("book").length);
    HttpSession session = request.getSession();
    BookDTO dto = new BookDTO();
    BookDAO dao = new BookDAO(); 
    String[] bookArr = request.getParameterValues("book");
    
    for(int i = 0; i < bookArr.length; i++) {
      int result = dao.addCart(bookArr[i], (String)session.getAttribute("mid"));
      if (result == 0) {
        response.sendRedirect("./booklist?error=1");
        break;
      }
    }
    response.sendRedirect("./booklist");
  }
}
