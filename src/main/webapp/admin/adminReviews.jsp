<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 관리 페이지</title>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script type="text/javascript">
  
</script>
</head>
<body>
	<h1>여기는 리뷰</h1>
	<div class="wrap">
		<%@ include file="menu.jsp"%>
		<div class="main">
			<table>
				<thead>
					<tr>
						<th>제목</th>
						<th>작가</th>
						<th>내용</th>
						<th>작성일</th>
						<th>삭제여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="list">
						<tr>
							<td>${list.rtitle }</td>
							<td>${list.rauthor }</td>
							<td>${list.rcontent }</td>
							<td>${list.rdate }</td>
							<td><select>
									<option <c:if test="${list.rdel eq 0 }">selected</c:if>
										value="0">삭제</option>
									<option <c:if test="${list.rdel eq 1 }">selected</c:if>
										value="1">공개</option>
							</select>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
