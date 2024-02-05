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

@WebServlet("/changename")
public class ChangeName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("changename.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if (session.getAttribute("mid") != null) {
			String mname = request.getParameter("newmname2");
			MemberDTO dto = new MemberDTO();
			dto.setMid((String)session.getAttribute("mname"));
			dto.setMpw(mname);
			MemberDAO dao = new MemberDAO();
			int result = dao.changePW(dto);
			
			if(result ==1) {
				response.sendRedirect("./board");
			} else {
				response.sendRedirect("./error.jsp");
			}
			
		} else {
			response.sendRedirect("./error.jsp");
			//로그인을 하지않았다면 에러 페이지로 넘어가게된다.
		}
	
	
	}

}
