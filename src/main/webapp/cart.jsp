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
<title>대출</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="./js/menu.js"></script>
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
			<input type="text" id="search-txt" placeholder="검색어를 입력하세요." />
			<button id="searchBtn">
				<i class="xi-search"></i>
			</button>
		</div>
		<form>
			<table class="booktable">
				<thead>
					<tr>
						<th>체크</th>
						<th>이미지</th>
						<th>제목</th>
						<th>저자</th>
						<th>출판사</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="list">
						<tr>
							<td class="w1"><input type="checkbox" name="book"
								value="${list.bisbn }" id="bookchk"></td>
							<td class="w2"><img alt="${list.btitle }"
								src="${list.bimage }" class="bookimg" id="book${list.bisbn }" /></td>
							<td class="w4 booklink"><a href="${list.blink }"
								target="_blank">${list.btitle }</a></td>
							<td class="w2">${list.bauthor }</td>
							<td class="w2">${list.bpublisher }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button class="add" formaction="./rent" formmethod="post">대출하기</button>
			<button class="add" formaction="./cartdelete" formmethod="post">삭제하기</button>
		</form>
	</article>
</body>
</html>