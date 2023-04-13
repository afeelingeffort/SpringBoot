<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 한 사용자만 들어옴</h1>
	<!-- jstl을 이용해 사용자 아이디와 패스워드 뜨도록 -->
	<form action="/info-proc" method="post">
		<h1>유저 정보</h1>
		<h3>Id : ${user.id}</h3>
		<h3>Pw : ${user.pw}</h3>
		<h3>유저 정보 : ${user}</h3>
	</form>
</body>
</html>