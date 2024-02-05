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
		$("#reviews-box").html("");
		showReview();
	});
	
	function makeReview() {

		let rno = $("#rno").val();
		let mno = $("#mno").val();
		let rtitle = $("#rtitle").val();
		let rauthor = $("#rauthor").val();
		let rcontent = $("#rcontent").val();
		//console.log(mno+"454545")

		$.ajax({
			url : "./bookreview", //요청할 서버url
			type : "post", //post 타입	
			dataType : 'text', //수신 타입
			data : {
				'rno' : rno,
				'mno' : mno,
				'rtitle' : rtitle,
				'rauthor' : rauthor,
				'rcontent' : rcontent }, //수신타입
			success : function(response) {
				//alert('작성했습니다.');
				//window.location.reload();
			},
			error : function(error) {
				alert('문제가 발생했습니다. : ' + error);
			}

		});
	}

	function showReview() {
		$.ajax({
			url : "./bookreview",
			type : "get",
			dataType : 'text',
			data : {},
			success : function(response) {
				$("#reviews-box").html(response);
			},
		
		});

	}
</script>

</head>

<body>
	<div class="container">
		<!-- <img src="./img/서재.jpg" alt="오류" class="img-fluid"
			alt="Responsive image"> -->
		<div class="info">
			<div class="stylish-regular">
				<h1>여기는 리뷰 공간입니다.</h1>
				<p>다른 사람들과 공유하고 싶은 재밌고 흥미진진한 책의 리뷰를 남겨주세요.</p>


				<div class="input-group mb-3" id="rnoInputGroup">
					<div class="input-group-prepend">
						<span class="input-group-text">리뷰번호</span>
					</div>
					<input type="text" class="form-control" id="rno">
				</div>

				<div class="input-group mb-3" id="mnoInputGroup">
					<div class="input-group-prepend">
						<span class="input-group-text">회원번호</span>
					</div>
					<input type="text" class="form-control" id="mno">
				</div>

				<div class="input-group mb-3" id="rtitleInputGroup">
					<div class="input-group-prepend">
						<span class="input-group-text">제목</span>
					</div>
					<input type="text" class="form-control" id="rtitle">
				</div>

				<div class="input-group mb-3" id="rauthorInputGroup">
					<div class="input-group-prepend">
						<span class="input-group-text">저자</span>
					</div>
					<input type="text" class="form-control" id="rauthor">
				</div>

				<div class="input-group mb-3" id="rcontentInputGroup">
					<div class="input-group-prepend">
						<span class="input-group-text">내용</span>
					</div>
					<textarea class="form-control" id="rcontent" cols="30" rows="5"
						placeholder="160자까지 입력할 수 있습니다."></textarea>
				</div>
				<div class="review">
					<button onclick="makeReview()" type="button" class="Rbtn">리뷰
						작성완료</button>
				</div>
			</div>
		</div>
		<div class="reviews">
			<div class="stylish-regular">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">제목</th>
							<th scope="col">저자</th>
							<th scope="col">내용</th>
						</tr>
					</thead>

					<tbody id="reviews-box">
						<c:forEach items="${allreviews }" var="eu">

							<tr>
								<td>${eu.rtitle }</td>
								<td>${eu.rauthor }</td>
								<td>${eu.rcontent }</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>


