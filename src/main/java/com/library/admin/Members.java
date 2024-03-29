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
import com.library.dto.MemberDTO;
import com.library.util.Util;

@WebServlet("/admin/members")
public class Members extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Members() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    AdminDAO dao = new AdminDAO();
    List<MemberDTO> list = null;
    int mgrade = 0;

    if (session.getAttribute("mgrade") != null) {
      mgrade = (int) session.getAttribute("mgrade");
    }
    if (request.getParameter("grade") == null || request.getParameter("grade").equals("")) {
      list = dao.memberList();
    } else {
      list = dao.memberList(Util.str2Int(request.getParameter("grade")));
    }
    request.setAttribute("list", list);

    // System.out.println(session.getAttribute("mgrade"));

    if (mgrade == 0 || mgrade != 9) {
      response.sendRedirect("/index");
    } else {

      RequestDispatcher rd = request.getRequestDispatcher("/admin/members.jsp");
      rd.forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    AdminDAO dao = new AdminDAO();
    int result = dao.memberUpdate(Util.str2Int(request.getParameter("grade")),
        Util.str2Int(request.getParameter("mno")));
    System.out.println(request.getParameter("grade") + request.getParameter("mno"));

    if (request.getParameter("currentgrade") == null || request.getParameter("currentgrade").equals("")) {
      response.sendRedirect("./members");
    } else {
      response.sendRedirect("./members?grade=" + request.getParameter("currentgrade"));

    }
  }
}
