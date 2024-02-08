<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="./css/menu2.css?ver=0.19" rel="stylesheet" />
<link href="./css/pagemenu.css?ver=0.19" rel="stylesheet" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<!-- 구글폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Diphylleia&family=East+Sea+Dokdo&family=Gowun+Batang&family=Orbit&family=Stylish&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap"
	rel="stylesheet">
<style>
body {
	margin: 0px;
	background-color: #E8E7D2;
	color: rgb(75, 52, 12);
}


h1 {
	font-family: 'Stylish', serif; /* 폰트 적용 */
	margin-bottom: 30px; /* 원하는 만큼의 간격 설정 */
}

h4 {
	font-family: 'Stylish', serif; /* 폰트 적용 */
	margin-bottom: 30px; /* 원하는 만큼의 간격 설정 */
	font-size: 18px; /* 기본 크기에서 5px 키워서 18px로 설정 */
}

button {
    background-color: #c9ba9b36;
    color: rgb(75 52 12 / 88%);
    border: 2px solid rgb(75 52 12 / 35%);
    border-radius: 5px;
    padding: 5px 15px;
    font-size: 13px;
    margin: 4px 2px;
    border-radius: 10px;
}

button:hover {
    background-color: #c9ba9b; /* 진한 베이지색 */
    color: white; /* 텍스트 색상 변경 */
}

.main {
	padding-left : 20px;
	margin-top: 75px;
	font-family: Oswald;
}

.list {
  	font-family: 'Stylish', serif; /* 폰트 적용 */
	margin-bottom: 30px; /* 원하는 만큼의 간격 설정 */
}


</style>
<script src="./js/menu.js"></script>
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
	<div class="container">
		<div class="main">
			<div>
				<article>
					<!-- test -->
					<h1>- MyPage</h1>
					<h4>
						Name&ensp; :&ensp; ${info.mname } <br>
						<br> ID&ensp; : &ensp;${info.mid }님, &ensp;HELLO😊
					</h4>
					<button type="button" onclick="window.location.href='./changename'">닉네임
						변경하기</button>
					<button type="button" onclick="window.location.href='./changePw'">패스워드
						변경하기</button>
					<br> <br>
				</article>
			</div>
			<hr>
			<div class="list">
				<h2>현재 대출중인 책 목록</h2>
				<table>
					<thead>
						<tr>
							<th></th>
							<th>반납 날짜</th>
							<th>책 제목</th>
						</tr>
					</thead>
					<tbody>
						<form action="/return" method="post">
							<c:forEach items="${list }" var="list">
								<tr class="booktablebody">
									<td><input type="checkbox" value="${list.rtno }"
										name="rtno" /></td>
									<td><h4>${list.rtdateadd }</h4></td>
									<td><h4>${list.btitle }</h4></td>
								</tr>
							</c:forEach>
							<button type="submit">반납하기</button>
						</form>
					</tbody>
				</table>
				<hr>
			</div>
		</div>
	</div>
</body>
</html>