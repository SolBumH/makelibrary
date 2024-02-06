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
    request.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();

    if (session.getAttribute("mid") != null) {
      System.out.println("요기");
      String mname = request.getParameter("newname2");
      MemberDTO dto = new MemberDTO();
      dto.setMid((String) (session.getAttribute("mid")));
      dto.setMname(mname);
      MemberDAO dao = new MemberDAO();
      int result = dao.changeName(dto);

      if (result == 1) {
        System.out.println("저기");
        session.removeAttribute("mname");
        session.setAttribute("mname", mname);
        response.sendRedirect("./info");
      } else {
        System.out.println("거기");
        response.sendRedirect("./error.jsp");
      }
    } else {
      System.out.println("요이");
      response.sendRedirect("./error.jsp");
      // 로그인을 하지않았다면 에러 페이지로 넘어가게된다.
    }
  }
}
