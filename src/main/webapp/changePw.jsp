<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경하기</title>
<link href="./css/pagemenu.css?ver=0.19" rel="stylesheet" />
<link href="./css/changeform.css?ver=0.19" rel="stylesheet" />
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<style>
body {
	background-color: #E8E7D2; /* 바탕화면 색상 지정 */
	color: rgb(75, 52, 12); /* 글자색 설정 */
}
</style>
<script src="./js/menu.js">


function check() {
	let pw1 = $("#pw1").val();
	let pw2 = $("#pw2").val();
	if (pw1.length < 8) {
		$('.pw-alert').show();
		alert("암호는 8글자 이상이어야 합니다.");
		$('#pw1').focus();
		return false;
	}
	if (pw1 != pw2) {
		alert("비밀번호가 일치하지 않습니다.");
		$('#pw2').val("");
		//""안의 값으로 바꿔줌 -> 비워놓으면 지운 것 처럼 보임
		$('#pw2').focus();
		return false;
	}
	$('.pw-alert').hide();
}
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<nav class="change">
		<ul>
			<li onclick="window.location.href='./info'">> My Page</li>
			<li onclick="window.location.href='./changename'">닉네임 변경</li>
			<li onclick="window.location.href='./changePw'">패스워드 변경</li>
			<li onclick="window.location.href='./bookRentList')">대출조회/대출이력</li>
			<li onclick="window.location.href='./bookreview')">나의 리뷰 작성</li>
			<c:if test="${sessionScope.mgrade eq 9 }"><li onclick="url('./admin/index')">관리자 페이지</li></c:if>
		</ul>
	</nav>

	<!-- 기본 구조는 form 구조임 -->
	<div class="changeform">
				<img class="king2" alt="login" src="./img/빅토리아.png">
		<h2>패스워드를 변경해주세요.</h2>
		<div>
			<form action="./changePw" method="post">

				<input type="text" name="pw1" placeholder="현재 비밀번호를 입력하세요"><br>
				<input type="text" name="pw2" placeholder="새로운 비밀번호를 입력하세요"><br>
				<input type="password" name="pw" placeholder="다시한번 새로운 비밀번호를 입력하세요">
				<button type="submit">변경하기</button>

			</form>
		</div>
	</div>
</body>
</html>