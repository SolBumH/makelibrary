package com.library.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/index")
public class AdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndex() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("mgrade"));
		// System.out.println(grade);

		if ((int)session.getAttribute("mgrade") != 9) {
			//System.out.println("요기");
			response.sendRedirect("/info");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/admin.jsp");// 파일 있는 경로
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
