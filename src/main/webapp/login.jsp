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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
	$('#mid').hide();//원래는 ready 바로 아래 두시는 것을 추천....
	$(".xi-comment-o").click(function(){
		$(".xi-comment-o").hide();
		//$(".comment-write").show();
		$('#mid').slideToggle('slow');
	});
	
	$("#mid").click(function(){
		let content = $("#midcontent").val();
		let bno = ${detail.no };
		if(content.length < 5){
			alert("댓글은 다섯글자 이상으로 적어주세요.");
			$("#midcontent").focus();
		} else {
			let form = $('<form></form>');
			form.attr('name', 'form');
			form.attr('method', 'post');
			form.attr('action', '#id');
			form.append($('<input/>', {type:'hidden', name:'content', value:content}));//json
			form.append($('<input/>', {type:'hidden', name:'bno', value:bno}));
			form.appendTo("body");
			form.submit();
		}
	});

</script>
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