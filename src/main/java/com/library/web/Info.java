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

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
  
 //비밀번호 변경해서 로그인할때
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		
		if (session.getAttribute("mid") != null) {
			//만약 아이디가 null이 아니라면
			String pw = request.getParameter("newPW");
			//MyInfo.jsp에서 설정한 새로운 비밀번호가 newPW라는 이름에 담겨서 온거를 PW에 담아준다
			MemberDTO dto = new MemberDTO();
			dto.setMid((String)session.getAttribute("mid"));
			// mid는 스트링만 넣을수있어 dto에서 스트링으로 설정했어
			dto.setMpw(pw);
			//dto에 pw를 넣을거야
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