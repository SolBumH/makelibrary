package com.library.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDAO;
import com.library.db.DBConnection_solbum;
import com.library.dto.BookDTO;
import com.library.util.Util;

@WebServlet("/booklist")
public class BookList extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public BookList() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    DBConnection_solbum db = new DBConnection_solbum();
    // request.setCharacterEncoding("utf-8");
    BookDAO dao = new BookDAO();
    int page;
    String book = "";
    // System.out.println(request.getParameter("search"));
    // System.out.println(search);
    if (request.getParameter("page") == null || request.getParameter("page").isEmpty()) {
      page = 1;
    } else {
      page = Util.str2Int(request.getParameter("page"));
    }
    int startPage;

    if (page <= 10) {
      startPage = 1;
    } else if (page % 10 == 0) {
      startPage = (page - 1) / 10 * 10 + 1;
    } else {
      startPage = (page / 10 * 10) + 1;
    }
    request.setAttribute("startPage", startPage);
    request.setAttribute("page", page);

    if (request.getParameter("search") == null || request.getParameter("search").isEmpty()) {
      // book = BookDAO.api(db.dbConn("자바", page)); // 괄호 안에 검색어 작성 필요
    } else {
      String search = request.getParameter("search");
      book = dao.api(db.dbConn(search, page)); // 괄호 안에 검색어 작성 필요
    }

    List<BookDTO> bookList = dao.bookInfo(book);
//    System.out.println(bookList.size());
    if (bookList != null) {
      for (int i = 0; i < bookList.size(); i++) {
        // System.out.println(bookList.get(i));
        // DB 저장하는 메소드 실행
        dao.insertList(bookList.get(i));
      }
    }
    request.setAttribute("bookList", bookList);
    RequestDispatcher rd = request.getRequestDispatcher("booklist.jsp");
    rd.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}
