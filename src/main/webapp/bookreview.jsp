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
	    let mno = $("#mno").val();
	    let rtitle = $("#rtitle").val();
	    let rauthor = $("#rauthor").val();
	    let rcontent = $("#rcontent").val();
	    
	    alert("mno: " + mno + ", rtitle: " + rtitle + ", rauthor: " + rauthor + ", rcontent: " + rcontent);
	    $.ajax({
	        type: "POST",
	        url: "./bookreview",
	        data: { mno_give: mno, rtitle_give: rtitle, rauthor_give: rauthor, rcontent_give: rcontent },
	        success: function (response) {
	            // alert(response);
	            window.location.reload();
	        }
	    });
	}

	function showReview() {
	    $.ajax({
	        type: "GET",
	        url: "./bookreview",
	        dataType: 'json',
	        success: function (response) {
	            let reviews = response.reviews;
	            if (reviews && reviews.length > 0) {
	                for (let i = 0; i < reviews.length; i++) {
	                    let title = reviews[i].rtitle;
	                    let author = reviews[i].rauthor;
	                    let review = reviews[i].rcontent;

	                    let temp_html =
	                        `<tr>
	                            <td>${i + 1}</td>
	                            <td>${title}</td>
	                            <td>${author}</td>
	                            <td>${review}</td>
	                        </tr>`;

	                    $("#reviews-box").append(temp_html);
	                }
	            } else {
	                console.error("No reviews found.");
	            }
	        }
	    });
	}



</script>

</head>

<body>
  <div class="container">
    <img src="./img/서재.jpg" alt="오류" class="img-fluid"
      alt="Responsive image">
    <div class="info">
      <div class="stylish-regular">
        <h1>여기는 리뷰 공간입니다.</h1>
        <p>다른 사람들과 공유하고 싶은 재밌고 흥미진진한 책의 리뷰를 남겨주세요.</p>

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
            <span class="input-group-text">리뷰</span>
          </div>
          <textarea class="form-control" id="rcontent" cols="30"
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
              <th scope="col">회원번호</th>
              <th scope="col">날짜</th>
              <th scope="col">제목</th>
              <th scope="col">저자</th>
              <th scope="col">리뷰</th>
            </tr>
          </thead>
          <tbody id="reviews-box">
                 
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>


