package com.library.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.BookDAO;
import com.library.dto.BookDTO;
import com.library.util.Util;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession();
				
				if(Util.intCheck(request.getParameter("mno")) && session.getAttribute("mid") != null) {
					int no = Util.str2Int(request.getParameter("mno"));
					BookDAO dao = new BookDAO();
					BookDTO dto = new BookDTO();
					dto.setMno(no);
					dto.setMid((String) session.getAttribute("mid"));
					
					
					int result = dao.delete(dto);
					
					if(result == 1) {
						response.sendRedirect("./board");
					} else {
						response.sendRedirect("./error.jsp");
					}
					
				} else {
					response.sendRedirect("./error.jsp");
				}
				
				
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
