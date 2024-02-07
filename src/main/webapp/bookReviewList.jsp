<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 리뷰 작성 목록 조회</title>
<link href="./css/menu2.css?ver=0.19" rel="stylesheet" />
<link href="./css/pagemenu.css?ver=0.19" rel="stylesheet" />
<link href="./css/list.css?ver=0.19" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
body {
	background-color: #E8E7D2;
	color: rgb(75, 52, 12);
}


</style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<nav class="change">
		<ul>
			<li onclick="window.location.href='./info'">My Page</li>
			<li onclick="window.location.href='./changename'">닉네임 변경</li>
			<li onclick="window.location.href='./changePw'">패스워드 변경</li>
			<li onclick="url('./bookRentList')">> 대출조회/대출이력</li>
			<li onclick="url('./bookReviewList')">> 나의 리뷰 작성</li>
		</ul>
	</nav>

	<nav class="list1">
		<h1>> 나의 리뷰 작성 목록 조회</h1>
		<table>
			<tr>
				<th>번 호</th>
				<th>제 목</th>
				<th>저 자</th>
				<th>내 용</th>
				<th>작성일</th>
			</tr>
			</nav>
				<c:forEach items="${list }" var="row">
									<tr>
										<td class="w1" >${row.rno }</td>
										<td class="w2">${row.rtitle }</td>
										<td class="w2">${row.rauthor }</td>
										<td class="w1">${row.rcontent }</td>
										<td class="w1"> <fmt:formatDate value="${row.rdate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									</tr></c:forEach>
		</table>
</body>
</html>