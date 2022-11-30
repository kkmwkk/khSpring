<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>DEV 게시판</title>
	<script src="//cndjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<br>
<a href="/board/list">게시판</a>
<script type="text/javascript">
$(document).ready(function(){
	$("#logoutBtn").on("click",function(){
		location.href="member/register";
	})
	
	$("#registerBtn").on("click",function(){
		location.href="member/register"
	})
	
	$("#memberUpdateBtn").on("click",function(){
		location.href="member/memberUpdateView"
	})
});
</script>
<body>
	<form name='homeForm' method="post" action="/member/login">
		<c:if test="${member == null }">
			<div>
				<label for="userId"></label>
				<input type="text" id="userId" name="userId">		
			</div>
			<div>
				<label for="userPass"></label>
				<input type="password" id="userPass" name="userPass">		
			</div>
			<div>
				<button type="submit">로그인</button>
				<button id="registerBtn" type="button">회원가입</button>				
			</div>
		</c:if>
		
		<c:if test="${member != null}">
			<div>
				<p>${member.userId}님 환영합니다.
				
				<button id="memberUpdateBtn" type="button">회원정보수정</button>
				<button id="logoutBtn" type="button">로그아웃</button>
			</div>
		</c:if>
		
		<c:if test="${msg == false}">
			<p style="color:red;">로그인 실패! 아이디와 비밀번호를 확인해 주세요!</p>
		</c:if>
	</form>
</body>
</html>
