<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="./css/login.css" rel="stylesheet"/>
<link href="./css/menu2.css" rel="stylesheet"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script type="text/javascript" src="./js/menu.js"></script>

</head>
<body>
 <%@ include file="menu.jsp"%>
	<div class="container">
		<div class="main">
			<div class="mainStyle">
				<img class="king" alt="login" src="./img/빅토리아.png">
				<form action="./login" method="post">
				<div class="login">
				<div class="id">
					<input type="text" name="mid" placeholder="아이디를 입력하세요">
					<input type="password" name="mpw" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="boxbtn">
					<button type="submit">로그인</button>
				</div>
			</div>
				</form>
				<a href="./join">회원가입</a>
				</div>
			</div>
		</div>
		<footer>
	
		</footer>
	</div>
</body>
</html>