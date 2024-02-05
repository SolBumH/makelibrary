<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닉네임 변경하기</title>
<link href="./css/pagemenu.css?ver=0.19" rel="stylesheet" />
<link href="./css/changeform.css?ver=0.19" rel="stylesheet" />
<style>
        body {
            background-color: #E8E7D2; /* 바탕화면 색상 지정 */
            color: rgb(75, 52, 12); /* 글자색 설정 */
        }
    </style>
<script src="./js/menu.js">
function check() {
	let pw1 = $("#newname").val();
	let pw2 = $("#newname2").val();
	if (pw1.length < 8) {
		$('.pw-alert').show();
		alert("암호는 8글자 이상이어야 합니다.");
		$('#newname').focus();
		return false;
	}
	if (newname != newname2) {
		alert("비밀번호가 일치하지 않습니다.");
		$('#newname2').val("");
		//""안의 값으로 바꿔줌 -> 비워놓으면 지운 것 처럼 보임
		$('#newname2').focus();
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
         <li onclick="url('./bookRentList')">대출 조회/반납연기</li>
         <li onclick="url('./rentList')">대출이력</li>
         <li onclick="url('./rentList')">도서 예약현황</li>
         <li onclick="url('./reviews')">나의 리뷰 작성</li>
         <li onclick="url('./board')">문의사항</li>
      </ul>
   </nav>
	
	<!-- 기본 구조는 form 구조임 -->
	<div class="changeform">
		<form action="./changeName" method="post">
			<img class="king2" alt="login" src="./img/빅토리아.png">
			<h2>닉네임을 변경해주세요.</h2>
			<input type="text" name="newname" placeholder="현재 닉네임을 입력하세요"><br>
			<!-- name은 서블릿에서 쓰려고 받아오는거야 , 자바를 쓸때 name에 써 -->
			<input type="text" name="newname2" placeholder="새로운 닉네임을 입력하세요">
			<button type="submit">변경하기</button>
		</form>
	</div>
</body>
</html>