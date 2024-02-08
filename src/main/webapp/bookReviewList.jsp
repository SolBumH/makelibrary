<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 리뷰 작성 목록 조회</title>
<link href="./css/menu2.css?ver=0.19" rel="stylesheet" />
<link href="./css/pagemenu.css?ver=0.19" rel="stylesheet" />
<link href="./css/list.css?ver=0.19" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!-- 구글폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Diphylleia&family=East+Sea+Dokdo&family=Gowun+Batang&family=Orbit&family=Stylish&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap"
	rel="stylesheet">

<script>
    function deleteReview(rno) {
        if (confirm("정말로 삭제하시겠습니까?")) {
            $.ajax({
                url: 'Delete',
                type: 'GET',
                data: { mno: mno , mid: mid },
                success: function(response) {
                    // 삭제가 성공했을 때 실행할 코드
                    location.reload(); // 페이지 새로고침
                },
                error: function(xhr, status, error) {
                    // 삭제가 실패했을 때 실행할 코드
                    alert("삭제에 실패했습니다.");
                }
            });
        }
    }
</script>
	
<style>
body {
	background-color: #E8E7D2;
	color: rgb(75, 52, 12);
}

table {
	font-family: 'Stylish', serif; /* 폰트 적용 */
	margin-bottom: 30px; /* 원하는 만큼의 간격 설정 */
}

h1 {
	padding-left : 20px;
	font-family: 'Stylish', serif; /* 폰트 적용 */
	margin-bottom: 30px; /* 원하는 만큼의 간격 설정 */
	font-size: 28px;
}
tr {
	font-size: 23px;
}
.review {
	font-family: 'Stylish', serif; /* 폰트 적용 */
	margin-bottom: 30px; /* 원하는 만큼의 간격 설정 */
	font-size: 19px; 
}


@font-face{
font-family:'DNFForgedBlade';font-style:normal;font-weight:300;
src:url('//cdn.df.nexon.com/img/common/font/DNFForgedBlade-Light.otf')format('opentype')}

@font-face{
font-family:'DNFForgedBlade';font-style:normal;font-weight:500;
src:url('//cdn.df.nexon.com/img/common/font/DNFForgedBlade-Medium.otf')format('opentype')}

@font-face{
font-family:'DNFForgedBlade';font-style:normal;font-weight:700;
src:url('//cdn.df.nexon.com/img/common/font/DNFForgedBlade-Bold.otf')format('opentype')}

button {
    background-color: #c9ba9b36;
    color: rgb(75 52 12 / 88%);
    border: 2px solid rgb(75 52 12 / 35%);
    border-radius: 5px;
    padding: 5px 15px;
    font-size: 13px;
    margin: 4px 2px;
    border-radius: 10px;
}

button:hover {
    background-color: #c9ba9b; /* 진한 베이지색 */
    color: white; /* 텍스트 색상 변경 */
}
</style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<nav class="change">
		<ul>
			<li onclick="url('./info')">My Page</li>
			<li onclick="url('./changename')">닉네임 변경</li>
			<li onclick="url('./changePw')">패스워드 변경</li>
			<li onclick="url('./bookRentList')">대출조회/대출이력</li>
			<li onclick="url('./bookReviewList')">> 나의 리뷰 작성</li>
			<c:if test="${sessionScope.mgrade eq 9 }">
				<li onclick="url('./admin/index')">관리자 페이지</li>
			</c:if>
		</ul>
	</nav>

	<nav class="list1">
		<h1>- 나의 리뷰 작성 목록</h1>
		<hr>
		<table>
			<tr>
				<th>번 호</th>
				<th>제 목</th>
				<th>내 &ensp;&ensp;&ensp;용</th>
				<th>작 성 일</th>
			</tr>
			</nav>
			<c:forEach items="${list }" var="row">
				<tr class="review">
					<td class="w1">${row.rno }</td>
					<td class="w2">${row.rtitle }</td>
					<td class="w1">${row.rcontent }</td>
					<td class="w1">${row.rdate}&ensp;&ensp;&ensp;<button type="button" onclick="deleteReview(${row.rno})">삭제</button></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>