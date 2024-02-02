<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경하기</title>
<link href="./css/pagemenu.css?ver=0.19" rel="stylesheet" />
<link href="./css/changeform.css?ver=0.19" rel="stylesheet" />
<style>
        body {
            background-color: #E8E7D2; /* 바탕화면 색상 지정 */
            color: rgb(75, 52, 12); /* 글자색 설정 */
        }
     
    </style>
<script src="./js/menu.js">
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<nav class="change">
      <ul>
      	
      	 <br>
         <br>
         <br>
         <li onclick="window.location.href='./info'">> My Page</li>
         <li onclick="window.location.href='./changename'"></i>닉네임 변경</li>
         <li onclick="window.location.href='./changePw'"></i>패스워드 변경</li>
         <li onclick="url('./rentList')"></i>대출 조회/반납연기</li>
         <li onclick="url('./rentList')"></i>대출이력</li>
         <li onclick="url('./rentList')"></i>도서 예약현황</li>
         <li onclick="url('./rentList')"></i>희망도서 신청내역</li>
         <li onclick="url('./reviews')"></i>나의 리뷰 작성</li>
         <li onclick="url('./board')"></i>문의사항</li>
      </ul>
   </nav>
   
	<!-- 기본 구조는 form 구조임 -->
	<div class="changeform">
		<form action="./changePw" method="post">
			<h2>패스워드 변경하기</h2>
			<input type="text" name="id" placeholder="현재 비밀번호를 입력하세요"><br>
			<input type="text" name="id" placeholder="새로운 비밀번호를 입력하세요"><br>
			<!-- name은 서블릿에서 쓰려고 받아오는거야 , 자바를 쓸때 name에 써 -->
			<input type="password" name="pw" placeholder="다시한번 새로운 비밀번호를 입력하세요">
			<button type="submit">변경하기</button>
		</form>
	</div>
</body>
</html>