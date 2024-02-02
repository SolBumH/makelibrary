<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관!</title>
<link href="./css/book.css" rel="stylesheet" />
<script type="text/javascript" src="./js/menu.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
  integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
  crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
  <%@ include file="menu.jsp"%>
  <div class="article">
    <h1>책 리스트</h1>
    <article>
      <c:choose>
        <%-- <c:when test="${fn:length(list) gt 0 }"> --%>
          <form action="./bookList">
            <table>
              <thead>
                <tr>
                  <th>선택</th>
                  <th>도서명</th>
                  <th>출판사</th>
                  <th>저자</th>
                  <th>대출가능여부</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${list }" var="row">
                  <tr>
                    <td class="w3"><input type='radio' name="book"
                      class="Btn" /></td>
                    <td class="w2">${row.bname }</td>
                    <td class="w1">${row.bpub }</td>
                    <td class="w1">${row.bwrite }</td>
                    <td class="w1">${row.brent }</td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
            <button onclick="location.href='./bookrental'">대여</button>
          </form>
          <div class="paging">
            <button onclick="paging(1)">⏮️</button>
            <button
              <c:if test="${page - 10 lt 1 }">disabled="disabled"</c:if>
              onclick="paging(${page - 10 })">◀️</button>
            <c:forEach begin="${startPage }" end="${endPage }" var="p">
              <button
                <c:if test="${page eq p }">class="currentBtn"</c:if>
                onclick="paging(${p })">${p }</button>
            </c:forEach>
            <button
              <c:if test="${page + 10 gt totalPage }">disabled="disabled"</c:if>
              onclick="paging(${page + 10 })">▶️</button>
            <button onclick="paging(${totalPage })">⏭️</button>

          </div>
        <%-- </c:when> --%>
      </c:choose>
    </article>
  </div>
</body>
</html>