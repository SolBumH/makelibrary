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

.love { 
	width: 100%;
    height: 100%;
    object-fit: cover; /* 이미지 비율 유지하면서 화면에 가득 채우기 */
    opacity: 0.7; /* 투명도 설정 */
}

.mainStyle {
	text-align: center;
	
}
</style>
<body>
	<%@ include file="menu.jsp"%>
	<article class="main">
		<div class="container">
			<div class="mainStyle">
				<div class='iceJaram-Rg'>
					<img class="love" alt="index" src="./img/도서관4.png"> <br>
					<div class='iceJaram-Rg'>
					</div>
				</div>
			</div>
		</div>
	</article>
</body>
</html>