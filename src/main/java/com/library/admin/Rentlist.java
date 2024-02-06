package com.library.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.AdminDAO;
import com.library.util.Util;

@WebServlet("/admin/rentlist")
public class Rentlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rentlist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		AdminDAO dao = new AdminDAO();
		list = dao.allRent();
		
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/rentlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("rtno"));
//		System.out.println(request.getParameter("rtenum"));
		AdminDAO dao = new AdminDAO();
		int result = dao.rentUpdate(Util.str2Int(request.getParameter("rtno")), Util.str2Int(request.getParameter("enum")));
		System.out.println(result);
			
		
		
		
		
		
	}

}
