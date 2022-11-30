<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring delete.jsp test</title>
</head>
<body>
	<form name="deleteForm" action="<c:url value="/board/delete"/>" method="post">
		<input name="seq" value="${seq}"/>
		비밀번호(숫자만 입력하세요)<input name="pwd"/>
		<input type="submit">
		<a href="<c:url value="/board/read/${seq}"/>">취소</a>
	</form>
	<div>${msg}</div>
</body>
</html>