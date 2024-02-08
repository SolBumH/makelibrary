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
	margin-left: 200px;
	padding: 0;
	text-align: center;
}

.rentlist1 {
margin-left: 180px;
	width: 400px;
	height: 100px;
}
</style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<nav class="change">
		<ul>
			<li onclick="url('./info')">MyPage</li>
			<li onclick="url('./changename')">닉네임 변경</li>
			<li onclick="url('./changePw')">패스워드 변경</li>
			<li onclick="url('./bookRentList')">> 대출조회/대출이력</li>
			<li onclick="url('./bookReviewList')">나의 리뷰 작성</li>
			<c:if test="${sessionScope.mgrade eq 9 }"><li onclick="url('./admin/index')">관리자 페이지</li></c:if>
		</ul>
	</nav>
	<h1>>대출 조회 리스트</h1>
	<nav class="rentlist1">
		<table>
			<tr>
				<th>도서 제목</th>
				<th>대출일</th>
				<th>반납 예정일</th>
			</tr>
			<c:forEach items="${bookrentlist }" var="row">
				<tr>
					<td class="w1">${row.btitle }</td>
					<td class="w1">${row.rtdate }</td>
					<td class="w1">${row.rtdateadd }</td>
				</tr>
			</c:forEach>
			</nav>
		</table>
</body>
</html>