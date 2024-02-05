package com.library.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDAO;
import com.library.dto.BookDTO;

@WebServlet("/book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Book() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		// List<BookDTO> list = dao.bookList();
		// request.setAttribute("list", list);
		
		RequestDispatcher rs = request.getRequestDispatcher("book.jsp");
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
