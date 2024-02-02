<%@page import="java.util.List"%>
<%@page import="com.library.dto.ReviewDTO"%>
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
		alert("눌렀습니다.");
	    let title = $("#title").val();
	    let author = $("#author").val();
	    let reviewContent = $("#bookReview").val();
	    
	    alert("title: " + title + ", author: " + author + ", reviewContent: " + reviewContent);
		$.ajax({
			type : "POST",
			url : "./bookreview",
			 data: {title_give:title, author_give:author, review_give:reviewContent},
             success: function (response) {
            	 //alert(response);
            	 showReview();

			}
		});
	}

	function showReview() {
		$.ajax({
			type : "GET",
			url : "./bookreview",
			dataType : "json",
			  data: {},
              success: function (response) {
            	  let reviews = response["all_reviews"]
                  for(let i=0; i < reviews.length; i++){
                      let title = reviews[i]["title"]
                      let author = reviews[i]["author"]
                      let review = reviews[i]["review"]

                      let temp_html =
                      `<tr>
                          <td>${title}</td>
                          <td>${author}</td>
                          <td>${review}</td>
                        </tr>`

                   $("#reviews-box").append(temp_html)
                  }
              }
          })
      }
출처: https://parkjh7764.tistory.com/32 [HwanE Develop Blog:티스토리]

</script>

</head>

<body>
  <div class="container">
    <img src="./img/서재.jpg" alt="오류" class="img-fluid"
      alt="Responsive image">
    <div class="info">
      <div class="stylish-regular">
        <h1>여기는 리뷰 공간입니다.</h1>
        <p>재밌었던 책이나! 흥미진진했던 책의 리뷰를 남겨주세요.다른 사람들에게도 추천하고 싶은 그런 책으로요!</p>

        <div class="input-group mb-3" id="titleInputGroup">
          <div class="input-group-prepend">
            <span class="input-group-text">제목</span>
          </div>
          <input type="text" class="form-control" id="title">
        </div>

        <div class="input-group mb-3" id="authorInputGroup">
          <div class="input-group-prepend">
            <span class="input-group-text">저자</span>
          </div>
          <input type="text" class="form-control" id="author">
        </div>


        <div class="input-group mb-3" id="reviewInputGroup">
          <div class="input-group-prepend">
            <span class="input-group-text">리뷰</span>
          </div>
          <textarea class="form-control" id="bookReview" cols="30"
            rows="5" placeholder="160자까지 입력할 수 있습니다."></textarea>
        </div>
        <div class="review">
          <button onclick="makeReview()" type="button"
            class="btn btn-success">리뷰 작성완료</button>
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
              <th scope="col">리뷰</th>
            </tr>
          </thead>
          <tbody id="reviews-box">
            <tr>
              <td>길동이의 개발일지</td>
              <td>홍길동</td>
              <td>완전 열심히 하시는 모습이 보기 좋네요</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>