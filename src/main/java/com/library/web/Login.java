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

@WebServlet("/login")
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Login() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    rd.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getParameter("mid") != null && request.getParameter("mpw") != null) {
      MemberDTO dto = new MemberDTO();
      dto.setMid(request.getParameter("mid"));
      dto.setMpw(request.getParameter("mpw"));

      System.out.println("로그인로그인" + request.getParameter("mid") + request.getParameter("mpw"));

      MemberDAO dao = new MemberDAO();
      dto = dao.login(dto);

      if (dto.getCount() == 1) {
        System.out.println("정상 로그인");
        HttpSession session = request.getSession();

        session.setAttribute("mname", dto.getMname());
        session.setAttribute("mid", dto.getMid());

        response.sendRedirect("./info");
      }
    }
  }
}
