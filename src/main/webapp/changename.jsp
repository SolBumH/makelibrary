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
<script type="text/javascript" src="./js/menu.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
function check() {
	let pw1 = $("#newname").val();
	let pw2 = $("#newname2").val();
	if (pw2.length < 4) {
		$('.mname-alert').show();
		alert("닉네임은 4글자 이상입니다..");
		$('#newname').focus();
		return false;
	}

	$('.mname-alert').hide();
}
</script>
<style>
        body {
            background-color: #E8E7D2; /* 바탕화면 색상 지정 */
            color: rgb(75, 52, 12); /* 글자색 설정 */
        }
</style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<nav class="change">
      <ul>
			<li onclick="url('./info')"> My Page</li>
			<li onclick="url('./changename')">닉네임 변경</li>
			<li onclick="url('./changePw')">패스워드 변경</li>
			<li onclick="url('./bookRentList')">대출조회/대출이력</li>
			<li onclick="url('./bookreview')">나의 리뷰 작성</li>
      </ul>
   </nav>
	
	<!-- 기본 구조는 form 구조임 -->
	<div class="changeform">
		<form action="./changename" method="post">
			<img class="king2" alt="login" src="./img/빅토리아.png">
			<h2>닉네임을 변경해주세요.</h2>
			<input type="text" name="newname" id="newname" placeholder="현재 닉네임을 입력하세요"><br>
			<!-- name은 서블릿에서 쓰려고 받아오는거야 , 자바를 쓸때 name에 써 -->
			<input type="text" name="newname2" id="newname2"  placeholder="새로운 닉네임을 입력하세요">
			<p class="mname-alert">닉네임은 4글자 이상이여야합니다.</p>
			<button type="submit">변경하기</button>
		</form>
	</div>
</body>
</html>