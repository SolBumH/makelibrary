package com.library.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.MemberDAO;
import com.library.dto.MemberDTO;

@WebServlet("/changePw")
public class ChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePw() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("changePw.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if (session.getAttribute("mid") != null) {
			String pw = request.getParameter("pw2");
			MemberDTO dto = new MemberDTO();
			dto.setMid((String)session.getAttribute("mid"));
			dto.setMpw(pw);
			MemberDAO dao = new MemberDAO();
			int result = dao.changePW(dto);
			
			if(result ==1) {
				response.sendRedirect("./info");
				
				
				
			} else {
				response.sendRedirect("./error.jsp");
			}
			
		} else {
			response.sendRedirect("./error.jsp");
		}
		
	}

}
