<%@page
	import="org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대출 리스트</title>
<script src="../js/menu.js" type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

<script type="text/javascript">
	$(function() {
		$('select[name=rtenum]').on("change", function() {
			let val = $(this).val();
			let rtno = $(this).closest("tr").children().first().text();
			let form = $('<form></form>');
			form.attr('method', 'post');
			form.attr('action', './rentlist');
			form.append($('<input/>', {type : 'hidden', name : 'rtno', value : rtno}));
			form.append($('<input/>', {type : 'hidden', name : 'rtenum', value : val}));
			
			form.appendTo('body');
			form.submit();
		});
	});
</script>
</head>
<body>
	<h1>이런젠장</h1>
	<article>
		<form>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>회원아이디</th>
						<th>대출여부</th>
						<th>대출날짜</th>
						<th>대출기한</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="row">
						<tr>
							<td>${row.rtno }</td>
							<td>${row.btitle }</td>
							<td>${row.mid }</td>
							<td>
							<select name="rtenum">
									<option <c:if test="${row.rtenum eq '1' }">selected</c:if>
										value="1">1 대여중</option>
									<option <c:if test="${row.rtenum eq '0' }">selected</c:if>
										value="0">0 반납</option>
							</select></td>
							<td>${row.rtdate }</td>
							<td>${row.rtdateadd }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</article>
</body>
</html>