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
		try {
			
	        // 여기에 리뷰 작성 완료에 대한 처리 로직을 추가
	        String mnoString = request.getParameter("mno");
	        
	        if (mnoString == null || mnoString.isEmpty()) {
	            // mno 값이 없으면 예외 처리 또는 기본값 설정
	            throw new IllegalArgumentException("mno 값이 비어 있습니다.");
	        }
		       
	        int mno = Integer.parseInt(mnoString);
	        String rtitle = request.getParameter("rtitle_give");
	        String rauthor = request.getParameter("rauthor_give");
	        String rcontent = request.getParameter("rcontent_give");

	        System.out.println("Received review: mno= " + mno +  ", title=" + rtitle + ", author=" + rauthor + ", review=" + rcontent);

	        // ReviewDAO를 사용하여 리뷰를 데이터베이스에 저장
	        ReviewDAO reviewDAO = new ReviewDAO();
	        reviewDAO.addReview(mno, rtitle, rauthor, rcontent);

	        // 응답으로 "저장완료"를 전송 (필요한 경우)
	        response.getWriter().write("저장완료");

	        // 예시: 댓글을 다시 JSP 페이지로 포워딩
            response.sendRedirect(request.getContextPath() + "/bookreview"); // 페이지 리다이렉트

	    } catch (Exception e) {
	        // 예외가 발생하면 콘솔에 출력
	        e.printStackTrace();

	        // 예외 메시지를 응답으로 전송
	        response.getWriter().write("예외 발생: " + e.getMessage());
	    }
	}
	
}

