<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/rentlist2.css" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<meta charset="UTF-8">
<title>도서 대출 리스트</title>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
	$(function() {
		$('select[name=rtenum]').on("change", function() {
			let val = $(this).val();
			let rtno = $(this).closest("tr").children().first().text();
			let form = $('<form></form>');
			form.attr('method', 'post');
			form.attr('action', './rentlist');
			form.append($('<input/>', {
				type : 'hidden',
				name : 'rtno',
				value : rtno
			}));
			form.append($('<input/>', {
				type : 'hidden',
				name : 'rtenum',
				value : val
			}));

			form.appendTo('body');
			form.submit();
		});
	});
</script>
</head>
<body>
	<h1 class="id">대출이력 관리 시스템</h1>
	<div class="wrap">
	<nav class="me">
		<%@ include file="menu.jsp"%>
	</nav>
	<div class="main">
	<article class="a">
		<form>
				<ul class="ab">
					<li onclick="url('./rentlist?rtenum=')">전체보기</li>
					<li onclick="url('./rentlist?rtenum=0')"><i
						class="xi-close-circle-o"></i> 반납</li>
					<li onclick="url('./rentlist?rtenum=1')"><i
						class="xi-minus-circle-o"></i> 대출</li>
				</ul>
			<table class="renttable">
				<thead>
					<tr class="ti">
						<th>번호</th>
						<th>아이디</th>
						<th>제 목</th>
						<th>대출일</th>
						<th>반납일</th>
						<th>대출여부</th>
					</tr>
				</thead>
				<tbody class="rentbody">
					<c:forEach items="${list }" var="row">
						<tr>
							<td class="r1">${row.rtno }</td>
							<td class="r4">${row.mid }</td>
							<td class="r2">${row.btitle }</td>
							<td class="r3">${row.rtdate }</td>
							<td class="r3">${row.rtdateadd }</td>
							<td class="r4"><select name="rtenum">
									<option <c:if test="${row.rtenum eq '1' }">selected</c:if>
										value="1">1 대여중</option>
									<option <c:if test="${row.rtenum eq '0' }">selected</c:if>
										value="0">0 반납</option>
							</select></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</article>
	</div>
	</div>
	
</body>
</html>