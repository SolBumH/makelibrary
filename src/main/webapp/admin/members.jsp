<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지 - 사용자 관리</title>
<link href="../css/admin.css?ver=0.17" rel="stylesheet" />
<script type="text/javascript" src="../js/meun.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

<script>
$(function(){
	$('select[name=grade]').on("change", function(){
		let val = $(this).val();//
		let mno = $(this).closest("tr").children().first().text();
		// alert(val + " : " + mno);
		let form = $('<form></form>');
		form.attr('method','post');
		form.attr('action','./members');
		form.append($('<input/>',{type : 'hidden', name : 'mno', value : mno}));
		form.append($('<input/>',{type : 'hidden', name : 'grade', value : val}));
		<c:if test="${param.grade ne null}">
		form.append($('<input/>', {type : 'hidden', name : 'currengrade', value : ${param.grade}}));
		</c:if>
		form.appendTo('body');
		form.submit();
	});
});
</script>
</head>
<body>
	<h1>회 원 관 리</h1>
	<div class="wrap">
		<%@ include file="menu.jsp"%>
		<div class="main">
			<article>
				<div class="nav-lists">
					<ul class="nav-lists-group">
						<li class="nav-lists-item" onclick="url('./members?grade=0')">탈퇴</li>
						<li class="nav-lists-item" onclick="url('./members?grade=1')">강퇴</li>
						<li class="nav-lists-item" onclick="url('./members?grade=3')">정지</li>
						<li class="nav-lists-item" onclick="url('./members?grade=5')">정상</li>
						<li class="nav-lists-item" onclick="url('./members?grade=9')">관리자</li>
					</ul>
				</div>

				<table>
					<div class="search">
						<input type="text" id="search">
						<button id="searchBtn">검색</button>
					</div>
					<thead>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>가입일</th>
							<th>등급</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="row">
							<tr class="row${row.mgrade }">
								<td class="d1">${row.mno }</td>
								<td class="title">${row.mid }</td>
								<td class="d2">${row.mname }</td>
								<td class="d2">${row.mdate }</td>
								<td class="d1"><select name="grade">
										<optgroup label="정지">
											<option
												<c:if test="${row.mgrade eq 0 }"> selected="selected"</c:if>
												value="0">탈퇴</option>
											<option
												<c:if test="${row.mgrade eq 1 }"> selected="selected"</c:if>
												value="1">강퇴</option>
										</optgroup>
										<optgroup label="관리요망">
											<option
												<c:if test="${row.mgrade eq 3 }"> selected="selected"</c:if>
												value="3">관리요망</option>
										</optgroup>
										<optgroup label="정상회원">
											<option
												<c:if test="${row.mgrade eq 5 }"> selected="selected"</c:if>
												value="5">정상회원</option>
										</optgroup>
										<optgroup label="관리자">
											<option
												<c:if test="${row.mgrade eq 9 }"> selected="selected"</c:if>
												value="9">관리자</option>
										</optgroup>
								</select></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</article>
		</div>
	</div>
</body>
</html>