package com.library.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.MemberDAO;
import com.library.dto.MemberDTO;

@WebServlet("/idCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IdCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		MemberDTO dto = new MemberDTO();
		dto.setMid(mid);
		MemberDAO dao = new MemberDAO();
		int result = dao.idCheck(dto);
		//System.out.println("검사요청이 들어온 ID : " + id + " 결과는 : " + result);
		
		PrintWriter mpw = response.getWriter();
		mpw.print(result);
	}

}
