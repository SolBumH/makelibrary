package com.library.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.library.dao.MemberDAO;
import com.library.dto.MemberDTO;

@WebServlet("/info")
public class Info extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Info() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("mid") != null) {
			
			MemberDTO dto = new MemberDTO();
			dto.setMid((String) session.getAttribute("mid"));;
			
			MemberDAO dao = new MemberDAO();
			dto = dao.info(dto);
			request.setAttribute("info", dto);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
		rd.forward(request, response);
	}

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}