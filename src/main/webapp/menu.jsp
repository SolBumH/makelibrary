<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="./css/menu2.css" rel="stylesheet" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script type="text/javascript" src="./js/menu.js"></script>
<nav class="menu-nav">
    <ul>
        <li onclick="url('./index')"><i class="xi-library"></i>Home</li>
        <li onclick="url('./bookreview')"><i class="xi-library-books-o"></i>Board</li>
        <li onclick="url('./booklist')"><i class="xi-book"></i>Book List</li>
        <c:choose><c:when test="${sessionScope.mname eq null }">
        <li onclick="url('./login')"><i class="xi-garden"></i>Login</li></c:when><c:otherwise>
        <li onclick="url('./info')"><i class="xi-bookmark"></i>${sessionScope.mname }님</li>
        <li onclick="url('./logout')"><i class="xi-emoticon-smiley-o">Logout</li></c:otherwise></c:choose>
    </ul>
</nav>