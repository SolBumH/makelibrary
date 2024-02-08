package com.library.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.BookDAO;
import com.library.dao.ReviewDAO;
import com.library.dto.BookDTO;
import com.library.dto.ReviewDTO;
import com.library.util.Util;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("mid") != null && request.getParameter("rno") != null) {
			ReviewDAO dao = new ReviewDAO();
			ReviewDTO dto = new ReviewDTO();
			dto.setMid((String) session.getAttribute("mid"));
			dto.setRno(Util.str2Int(request.getParameter("rno")));
			int result = dao.delete(dto);

			if (result == 1) {
				response.sendRedirect("./bookReviewList");
			} else {
				response.sendRedirect("./error.jsp");
			}
		} else {
			response.sendRedirect("./error.jsp");
		}
	}
}
