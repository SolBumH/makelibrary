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

import com.library.dao.ReviewDAO;
import com.library.dto.ReviewDTO;

@WebServlet("/bookReviewList")
public class BookReviewList extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public BookReviewList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
 
	      HttpSession session = request.getSession();
	      String mid = (String)(session.getAttribute("mid"));
	      // session에서 mid 값을 받아오기
	      
	      if(session.getAttribute("mid") != null && !session.getAttribute("mid").equals("")) {
	    	  ReviewDAO dao = new ReviewDAO();
	    	  List<ReviewDTO> list = dao.myReviews(mid);
	    	  
	    	  request.setAttribute("list", list); // "list"라는 변수명으로 보낸다
	    	  
	    	  RequestDispatcher rd = request.getRequestDispatcher("bookReviewList.jsp"); //board.jsp페이지로
	    	  rd.forward(request, response);
	    	  
	      } else {
	    	  
	    	  response.sendRedirect("/login");
	      }
	      
	   }
    	

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}