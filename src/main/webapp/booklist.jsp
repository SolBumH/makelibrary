<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/book.css" />
<link rel="stylesheet"
  href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<meta charset="UTF-8">
<title>대출</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
  $(function() {
    $("#searchBtn").click(function() {
      let search = $('#search').val();
      // alert(encodeURIComponent(search));
      location.href = "./booklist?search=" + search;
    });
  });
  
  // let search = new URLSearchParams(window.location.search);
  // const page = new URL(location.href).searchParams.get('page');
  const search = new URL(location.href).searchParams.get('search');
  // alert(search.substring(lastIndexOf('=') + 1));
  function paging(no) {
    location.href = "./booklist?page=" + no + "&search=" + search;
  }
  // console.log(typeof location.search);
</script>
</head>
<body>
  <%@ include file="menu.jsp"%>
  <article class="main">
    <h1>대출하기</h1>
    <div class="search">
      <input type="text" id="search" />
      <button id="searchBtn">
        <i class="xi-search"></i>
      </button>
    </div>
    <c:choose>
      <c:when test="${param.search ne null && param.search ne ''}">
        <form action="./addCart" method="post">
          <table class="booktable">
            <thead>
              <tr>
                <th>선택</th>
                <th>이미지</th>
                <th>제목</th>
                <th>저자</th>
                <th>출판사</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${bookList }" var="bookList">
                <tr>
                  <td class="w1"><input type="checkbox" name="book"
                    value="${bookList.isbn }" id="bookchk"></td>
                  <td class="w2"><img alt="${bookList.title }"
                    src="${bookList.image }" class="bookimg"
                    id="book${bookList.isbn }"/></td>
                  <td class="w4 booklink"><a href="${bookList.link }" target="_blank">${bookList.title }</a></td>
                  <td class="w1">${bookList.author }</td>
                  <td class="w2">${bookList.publisher }</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <button type="submit">담기</button>
        </form>
        <div class="paging">
          <button class="pageBtn" onclick="paging(1)">‍🥔‍</button>
          <button class="pageBtn"
            <c:if test="${param.page - 10 lt 1 }">disabled="disabled"</c:if>
            onclick="paging(${param.page - 1})">🥕</button>
          <c:forEach begin="${startPage }" end="${startPage + 9 }"
            var="p">
            <button class="pageBtn"
              <c:if test="${page eq p }">id="currentBtn"</c:if>
              onclick="paging(${p})">${p }</button>
          </c:forEach>
          <button class="pageBtn"
            <c:if test="${param.page + 10 gt totalPage }">disabled="disabled"</c:if>
            onclick="paging(${param.page + 1})">🥕</button>
          <button class="pageBtn" onclick="paging(${totalPage})">🥔</button>
        </div>
      </c:when>
      <c:otherwise>
        <h1>검색하세요</h1>
      </c:otherwise>
    </c:choose>
    <c:if test="${param.error ne null}">오류가 발생했습니다</c:if>
  </article>
</body>
</html>