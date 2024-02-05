package com.library.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.MemberDAO;
import com.library.dto.MemberDTO;

@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Join() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//String mid=request.getParameter("mid");
		//String mname=request.getParameter("mname");
		//String mpw1=request.getParameter("mpw1");
		//System.out.println(mid+", "+mname+", "+mpw1);

		MemberDTO dto = new MemberDTO();
		dto.setMid(request.getParameter("mid"));
		dto.setMname(request.getParameter("mname"));
		dto.setMpw(request.getParameter("mpw1"));
		

		MemberDAO dao = new MemberDAO();

		int result = dao.join(dto);

		if (result == 1) {
			response.sendRedirect("./login");
		} else {
			response.sendRedirect("./error");

		}
	}

}
