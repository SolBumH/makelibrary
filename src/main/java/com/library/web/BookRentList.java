package com.library.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.MemberDAO;
import com.library.dto.BookrentDTO;

@WebServlet("/bookRentList")
public class BookRentList extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public BookRentList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        HttpSession session = request.getSession();
        List<BookrentDTO> bookrentlist = dao.bookRentList((String)session.getAttribute("mid"));
        request.setAttribute("bookrentlist", bookrentlist);
    	// 수정하기-효진
    	RequestDispatcher rd = request.getRequestDispatcher("bookRentList.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}