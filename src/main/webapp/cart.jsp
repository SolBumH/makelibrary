<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body>
  <%@ include file="menu.jsp"%>
  
  
  <article class="main">
    <h1>장바구니</h1>

    <div>
      <c:forEach items="${bookList }" var="row">
          ${row.title } / ${row.author } / ${row.publisher } <br>
      </c:forEach>
    </div>
    
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