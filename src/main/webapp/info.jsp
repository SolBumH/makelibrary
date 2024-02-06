<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="./css/menu2.css?ver=0.19" rel="stylesheet" />
<link href="./css/pagemenu.css?ver=0.19" rel="stylesheet" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
   href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap"
   rel="stylesheet">
<style>
body {
   background-color: #E8E7D2;
   color: rgb(75, 52, 12);
}

.main {
   margin-top : 75px;
   font-family: Oswald;
}
h1 {
   margin-bottom: 30px; /* 원하는 만큼의 간격 설정 */
}

h4 {
   margin-bottom: 30px; /* 원하는 만큼의 간격 설정 */
}
</style>
<script src="./js/menu.js"></script>
</head>
<body>
   <%@ include file="menu.jsp"%>
   <nav class="change">
      <ul>
  			<li onclick="window.location.href='./info'">> My Page</li>
			<li onclick="window.location.href='./changename'">닉네임 변경</li>
			<li onclick="window.location.href='./changePw'">패스워드 변경</li>
			<li onclick="url('./bookRentList')">대출조회/대출이력</li>
			<li onclick="url('./bookReviewList')">나의 리뷰 작성</li>
      </ul>
   </nav>
   <div class="container">
      <div class="main">
         <div>
            <article>
               <!-- test -->
               <h1> MyPage</h1>
               <h4>
                  Name : ${info.mname } <br><br>
                  ID : ${info.mid }님, HELLO😊
               </h4>
               <button type="button" onclick="window.location.href='./changename'">닉네임
                  변경하기</button>
               <button type="button" onclick="window.location.href='./changePw'">패스워드
                  변경하기</button>
               <br> <br>
            </article>
         </div>
         <hr>
         <div class="list">
            <h2> 현재 대출중인 책 목록</h2>
            <h4>list1</h4>
            <h4>list2</h4>
            <h4>list3</h4>
            <h4>list4</h4>
            <h4>list5</h4>
             <button type="button" onclick="window.location.href='./bookRentList'">현재 대출중인 책 리스트 바로가기</button>
            <hr>
            <button type="button" onclick="window.location.href='./main'">HomePage</button>
         </div>
      </div>
   </div>
</body>
</html>