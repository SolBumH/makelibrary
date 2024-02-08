<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출 조회 리스트</title>
<link href="./css/menu2.css?ver=0.19" rel="stylesheet" />
<link href="./css/pagemenu.css?ver=0.19" rel="stylesheet" />
<style>
body {
	background-color: #E8E7D2;
	color: rgb(75, 52, 12);
}

h1 {
	margin-top: 80px;
	margin-left: auto;
	padding: 0;
	text-align: center;
}

table, tr, td{
	border-collapse:separate;
	margin-left : auto;
	margin-right: auto;
	height: auto;
	border-bottom: inset;
	text-align: center;
	border: ridge;
	font-size: xx-large;
}
</style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<nav class="change">
		<ul>
			<li onclick="window.location.href='./info'">> My Page</li>
			<li onclick="window.location.href='./changename'">닉네임 변경</li>
			<li onclick="window.location.href='./changePw'">패스워드 변경</li>
			<li onclick="window.location.href='./bookRentList'">대출조회/대출이력</li>
			<li onclick="window.location.href='./bookreview'">나의 리뷰 작성</li>
			<c:if test="${sessionScope.mgrade eq 9 }">
				<li onclick="url('./admin/index')">관리자 페이지</li>
			</c:if>
		</ul>
	</nav>
	<h1>>대출 조회 리스트</h1>
	<nav class="rentlist1">
		<table>
			<tr>
				<th scope="col">도서 제목</th>
				<th scope="col">대출일</th>
				<th scope="col">반납 예정일</th>
			</tr>
			<c:forEach items="${bookrentlist }" var="row">
				<tr>
					<td class="noBorder">${row.btitle }</td>
					<td class="noBorder">${row.rtdate }</td>
					<td class="noBorder">${row.rtdateadd }</td>
				</tr>
			</c:forEach>
			</nav>
		</table>
</body>
</html>