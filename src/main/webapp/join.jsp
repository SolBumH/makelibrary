<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="./css/menu2.css" rel="stylesheet" />
<script type="text/javascript" src="./js/menu.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	//$(document).ready(function (){ 다른 모양
	//글로벌 변수
	let idCheckBool = false;
	
	$(function (){//제이쿼리 시작문 = 제이쿼리 시작합니다.
		$('.mid-alert, .mname-alert, .mpw-alert').hide();
		
		//onchange()
		//$("#id").change(function (){
		//	alert("아이디입력창 값이 변경되었습니다.");
		//});
		$('#mid').on("change keyup paste", function(){
			//alert("아이디입력창 값이 변경되었습니다.");
			$('.mid-alert').show();
			$('.mid-alert').html('<p class="alert">당신이 입력한 ID는 ' + $('#mid').val() +  '</p>');
			if($('#mid').val().length > 10){
				idCheck();
			}
		});
		
		
		
	});

	function check() {
		// $(선택자).할일();
		let mid = $("#mid").val();
		if(mid.length < 3 || mid == ""){
			$('.mid-alert').show();
			$("#mid").focus();
			return false;
		} else {
			$('.mid-alert').hide();
		}
		if(!idCheckBool){
			alert("ID 검사를 먼저 실행해주세요.");
			return false;
		}
		
		let mname = $('#mname').val();
		if(mname.length < 3){
			$('.mname-alert').show();
			$('#mname').focus();
			return false;
		}
		$('.mname-alert').hide();
		
		let mpw1 = $('#mpw1').val();
		let mpw2 = $('#mpw2').val();
		if(mpw1.length < 3){
			$('.mpw-alert').show();
			$('#mpw1').focus();
			return false;
		}
		if(mpw2.length < 4){
			alert("암호는 4글자 이상이어야 합니다.");
			$('#mpw2').focus();
			return false;
		}
		if(mpw1 != mpw2){
			alert("암호가 일치하지 않습니다.");
			$('#mpw2').val("");
			$('#mpw2').focus();
			return false;
		}
		$('.mpw-alert').hide();
	}
	function idCheck(){
		// alert('id검사를 눌렀습니다');
		let mid = $('#mid').val();
		const regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"\sㄱ-ㅎㅏ-ㅣ가-힣]/g;//한글+공백
		//alert(regExp.test(id)); // 한글,공백 포함여부 검사하는 정규식
		//나중에는 영어 소문자, 숫자만
		/* const regExp = /^[a-z0-9]{5,15}$/; */
		if(mid.length < 5 || regExp.test(mid)){
			alert("아이디는 영문자 5글자 이상이고 특수문자가 없어야합니다.");
			$('.mid-alert').html('<p class="alert">아이디는 영문자 5글자 이상이고 특수문자가 없어야합니다.</p>')
			$('#mid').focus();
		} else {
			//AJAX = 1페이징, 2AJAX, 3파일업로드
			$.ajax({
				url : './idCheck',			//이동할 주소
				type : 'post',				//post / get
				dataType : 'text',			//수신 타입
				data : {'mid' : mid},			//보낼 값
				success : function(result){	//성공시
					//alert("통신에 성공했습니다");
					if(result == 1){
						//alert("이미 가입되어있습니다.");
						$('.mid-alert').append('<p class="alert">이미 가입되어있습니다.</p>');
						idCheckBool = false;
						$("#joinBtn").attr("disabled", "disabled");//비활성화 시키기
						$('#mid').focus();
					} else {
						//alert("가입할 수 있습니다. 다음을 계속 진행하세요.");
						$('.mid-alert').append('<p class="alert">가입할 수 있습니다.</p>');
						$('.mid-alert .alert').css("color","green");
						idCheckBool = true;
						$("#joinBtn").removeAttr("disabled");//비활성화 제거하기 = 활성화 시키기
						//$('#name').focus();
					}
				},
				error : function(request, status, error){//접속불가, 문제발생 등
					alert("문제가 발생했습니다");
				}
			});
		}
		return false;
	}
</script>
</head>
<body>
	<div class="container1">
		<header>
			<%@ include file="menu.jsp"%>
		</header>
		<div class="main">
			<div class="join-form">
				<div class="mx-5 p-5 bg-light rounded">
					<h1>회원가입</h1>
					<form action="./join" method="post" onsubmit="return check()">
						<div class="input-group mb-2">
							<label class="input-group-text">아이디</label> <input type="text"
								id="mid" name="mid" class="form-control" placeholder="아이디를 입력하세요">
							<button class="btn btn-light input-group-text"
								onclick="return idCheck()">ID검사</button>
						</div>
						<div class="input-group mb-2 mid-alert">
							<p class="alert">올바른 아이디를 입력하세요</p>
						</div>
						<div class="input-group mb-2">
							<label class="input-group-text">이&ensp;&ensp;름</label> <input
								type="text" id="mname" name="mname" class="form-control"
								placeholder="이름을 입력하세요">
						</div>
						<div class="input-group mb-2 mname-alert">
							<p class="alert">올바른 이름을 입력하세요</p>
						</div>
						<div class="input-group mb-2">
							<label class="input-group-text">암&ensp;&ensp;호</label> <input
								type="password" id="mpw1" name="mpw1" class="form-control"
								placeholder="암호를 입력하세요"> <label class="input-group-text">재입력</label>
							<input type="password" id="mpw2" name="mpw2" class="form-control"
								placeholder="한번 더 입력하세요">
						</div>
						<div class="input-group mb-2 mpw1-alert">
							<p class="alert">올바른 암호를 입력하세요</p>
						</div>
						<div class="input-group mb-2">
							<button type="reset" class="btn btn-light col-6">초기화</button>
							<button id="joinBtn" type="submit" disabled="disabled"
								class="btn btn-light col-6">가입하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>