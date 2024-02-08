package com.library.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.AdminDAO;
import com.library.dao.ReviewDAO;
import com.library.dto.ReviewDTO;

@WebServlet("/admin/reviews")
public class AdminReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminReviews() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("mgrade") != null && (int) session.getAttribute("mgrade") == 9) {
			AdminDAO dao = new AdminDAO();
			ReviewDTO dto = new ReviewDTO();

			List<ReviewDTO> list = dao.reviewList();
			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("adminReviews.jsp");
			rd.forward(request, response);
		} else {
			if (session.getAttribute("mid") != null) {
				response.sendRedirect("/index");
			} else {
				response.sendRedirect("/login");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO dao = new AdminDAO();
		dao.changeReviewDel(request.getParameter("rno"), request.getParameter("del"));

		response.sendRedirect("/admin/reviews");
	}
}
