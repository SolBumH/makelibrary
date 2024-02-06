package com.library.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.ReviewDAO;
import com.library.dto.ReviewDTO;

@WebServlet("/bookReviewList")
public class BookReviewList extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public BookReviewList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// 수정하기-효진
    	
	      
	      ReviewDAO dao = new ReviewDAO();
	      List<ReviewDTO> list = dao.showReviews();
	      
	      request.setAttribute("list", list); // "list"라는 변수명으로 보낸다
	      
	      RequestDispatcher rd = request.getRequestDispatcher("bookReviewList.jsp"); //board.jsp페이지로
	      rd.forward(request, response);
	   }
    	

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}