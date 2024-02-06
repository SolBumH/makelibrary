<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대출 리스트</title>
<script src="../js/menu.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<h1>이런젠장</h1>
	
	<form>
          <table>
            <thead>
              <tr>
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
                  <td>${row.btitle }</td>
                  <td>${row.mid }</td>
                  <td>${row.rtenum }</td>
                  <td>${row.rtdate }</td>
                  <td></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
	</form>

</body>
</html>