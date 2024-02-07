<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link href="./css/menu2.css" rel="stylesheet" />
<link href="./css/login.css" rel="stylesheet" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script type="text/javascript" src="./js/menu.js"></script>
</head>

<style>
body {
	margin:0px;
	background-color: #E8E7D2;
	color: rgb(75, 52, 12);
}

.main {
	margin-top: 75px;
	font-family: Oswald;
}
</style>
<body>
	<%@ include file="menu.jsp"%>
	<article class="main">
		<div class="container">
			<div class="mainStyle">
				<img class="king" alt="login" src="./img/빅토리아.png" width="250" height="100"> <br>
				<img class="love" alt="index" src="./img/도서관.png" width="700" height="500"> <br>
				<h3>'도서관'은 영원히 지속되리라. 불을 밝히고, 고독하고, 무한하고, 부동적이고, 
				<br>고귀한 책들로 무장하고, 쓸모없고, 부식하지 않고, 비밀스러운 모습으로 말이다.'
				<br>- 바벨의 도서관 中</h3>

			</div>
		</div>
	</article>
</body>
</html>