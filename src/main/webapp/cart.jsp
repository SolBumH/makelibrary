<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.library.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/book.css" />
<link rel="stylesheet"
  href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<meta charset="UTF-8">
<title>장바구니</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<%
//로그인 되어있는 아이디 가져오기
String id = (String)session.getAttribute("mid");
//id에 맞는 장바구니 목록 불러오기
BookDAO dao = new BookDAO();
List<HashMap<String,String>> list = dao.get
%>
</head>
<body>
  <%@ include file="menu.jsp"%>
  <article class="main">
<<<<<<< HEAD
    <h1>장바구니</h1>

=======
    <h1>대출하기</h1>
    <div class="search">
      <input type="text" id="search" />
      <button id="searchBtn">
        <i class="xi-search"></i>
      </button>
    </div>
    리스트 : ${bookList }
    <div>
      <c:forEach items="${bookList }" var="row">
          ${row.title } / ${row.author } / ${row.publisher } <br>
      </c:forEach>
    </div>
    
    <c:choose>
      <c:when test="${param.search ne null && param.search ne ''}">
        <form action="./booklist" method="post">
>>>>>>> 786bf3adc22d6e4154c117d0478df105cb2cc703
          <table class="booktable">
            <thead>
              <tr>
                <th>번호</th>
                <th>책이름</th>
                <th>이미지</th>
                <th>작가</th>
                <th>출판사</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${bookList }" var="bookList">
                <tr>
                  <td class="w1">${bookList.cartno }</td>
                  <td class="w1">${bookList.bname }</td>
                  <td class="w2"><img alt="${bookList.bimg }"
                    src="${bookList.image }" class="bookimg"
                    id="book${bookList.isbn }"/></td>
                  <td class="w4 booklink"><a href="${bookList.blink }" target="_blank">${bookList.title }</a></td>
                  <td class="w1">${bookList.bauthor }</td>
                  <td class="w2">${bookList.bpublisher }</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <button type="submit">대출하기</button>




  </article>
</body>
</html>