<%@page import="java.util.List"%>
<%@page import="com.library.dto.ReviewDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<!-- Webpage Title -->
<title>리뷰 공간</title>



<!-- Reqyired meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- Your custom CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/review.css">
 <link href="./css/menu2.css" rel="stylesheet" /> 
 
<!-- JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<!-- 구글폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Diphylleia&family=East+Sea+Dokdo&family=Gowun+Batang&family=Orbit&family=Stylish&display=swap"
	rel="stylesheet">
	
   


<script type="text/javascript">
$(document).ready(function() {
	
	$('.Rbtn').click(function() {
		let rtitle = $("#rtitle").val();
		let rcontent = $("#rcontent").val();
		
		$.ajax({
			url : "./bookreview", //요청할 서버url
			type : "post", //post 타입	
			dataType : 'text', //수신 타입
			data : {
				'rtitle' : rtitle,
				'rcontent' : rcontent,
			}, //수신타입
			success : function(response) {
				 alert('작성했습니다.');
				 window.location.href = "./bookreview";
			},
			error : function(error) {
				alert('문제가 발생했습니다. : ' + error);
			}
		});
	});
	
	function makeReview() {

		


	}
});
</script>

</head>

<body>
 <%@ include file="menu.jsp"%>
	<div class="container">	
		<div class="info">
			<div class="stylish-regular">
				
				<br> 
				<br>
				<h1>이곳은 리뷰 공간입니다.</h1>
				<p>"남의 책을 읽는데 시간을 보내라. 남이 고생한 것에 의해 쉽게 자신을 개선할 수 있다." -소크라테스-</p>
				<br>				

				<div class="input-group mb-3" id="rtitleInputGroup">
					<div class="input-group-prepend">
						<span class="input-group-text">제목</span>
					</div>
					<input type="text" class="form-control" id="rtitle">
				</div>

			<!-- 	<div class="input-group mb-3" id="mnameInputGroup">
					<div class="input-group-prepend">
						<span class="input-group-text">글쓴이</span>
					</div>
					<input type="text" class="form-control" id="mname">
				</div> -->

				<div class="input-group mb-3" id="rcontentInputGroup">
					<div class="input-group-prepend">
						<span class="input-group-text">내용</span>
					</div>
					<textarea class="form-control" id="rcontent" cols="30" rows="5"
						placeholder="160자까지 입력할 수 있습니다." maxlength="180"></textarea>
				</div>
				<div class="review">
				<c:if test="${sessionScope.mid ne null }">							
					<button type="button" class="Rbtn" onclick="needLogin()">리뷰 작성완료</button>
				</div>
				</c:if>
			</div>
		</div>
		<div class="reviews">
			<div class="stylish-regular">
				<table class="table">
					<thead>
						<tr>
						<tr>
						<tr>
							<th scope="col">제목</th>
							<th scope="col">내용</th>
							<th scope="col">작성자</th>
						</tr>
					</thead>

					<tbody id="reviews-box">
						<c:forEach items="${allreviews }" var="eu">

							<tr>
								<td class="w1">${eu.rtitle }</td>
								<td class="w2">${eu.rcontent }</td>
								<td class="w3">${eu.mname }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>


