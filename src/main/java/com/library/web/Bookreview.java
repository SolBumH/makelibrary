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

@WebServlet("/bookreview")
public class Bookreview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Bookreview() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		// ReviewDAO를 사용하여 데이터베이스에서 리뷰 리스트를 가져옴
		ReviewDAO reviewDAO = new ReviewDAO();
		List<ReviewDTO> reviews = reviewDAO.getReviews();

		// 리뷰 리스트를 request 속성에 저장
		request.setAttribute("reviews", reviews);
		
		

		// JSP 페이지로 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("bookreview.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			reviewDAO.addReview(reviewDTO);
		
			String mno = request.getParameter("mno_give");
	        String rtitle = request.getParameter("rtitle_give");
	        String rauthor = request.getParameter("rauthor_give");
	        String rcontent = request.getParameter("rcontent_give");

	        System.out.println("Received review: mno= " + mno +  ", title=" + rtitle + ", author=" + rauthor + ", review=" + rcontent);

	        // 받은 데이터를 ReviewDTO에 설정
	        ReviewDTO reviewDTO = new ReviewDTO();
	        reviewDTO.setMno(Integer.parseInt(mno));  // String을 int로 변환
	        reviewDTO.setRtitle(rtitle);
	        reviewDTO.setRauthor(rauthor);
	        reviewDTO.setRcontent(rcontent);

	       

	        // 성공적인 응답 전송
	        response.getWriter().write("리뷰가 성공적으로 저장되었습니다.");
	    }
	
}

