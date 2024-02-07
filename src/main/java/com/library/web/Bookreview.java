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
		List<ReviewDTO> allreviews = reviewDAO.showReviews();

		// 리뷰 리스트를 request 속성에 저장
		request.setAttribute("allreviews", allreviews);

		// JSP 페이지로 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("bookreview.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");

		ReviewDTO dto = new ReviewDTO();
		dto.setRtitle(request.getParameter("rtitle"));
		dto.setRcontent(request.getParameter("rcontent"));
		dto.setMid(mid);

		ReviewDAO dao = new ReviewDAO();
		dao.makeReview(dto);
		
		response.sendRedirect("/bookreview");
	}
}

// 성공적인 응답 전송
//response.getWriter().write("리뷰가 성공적으로 저장되었습니다.");}}
