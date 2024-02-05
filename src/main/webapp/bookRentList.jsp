<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.rentlist1 {
	margin-top: 80px;
	margin-left: 200px;
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
			<li onclick="url('./bookRentList')">대출 조회/반납연기</li>
			<li onclick="url('./bookrent')">대출이력</li>
			<li onclick="url('./rentList')">도서 예약현황</li>
			<li onclick="url('./reviews')">나의 리뷰 작성</li>
			<li onclick="url('./board')">문의사항</li>
		</ul>
	</nav>
	<nav class="rentlist1"> 
	
	
	
		<h1>>대출 조회 리스트</h1>
		<table>
			<tr>
				<th>도서 제목</th>
				<th>대출자</th>
				<th>대출일</th>
				<th>반납 예정일</th>
			</tr>
			</nav>
		</table>
</body>
</html>