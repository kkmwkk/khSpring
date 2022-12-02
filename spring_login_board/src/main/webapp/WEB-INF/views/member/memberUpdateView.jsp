<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	  <!-- 최소화된 최신 CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
      <!-- 부가적인 테마 -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
       
       <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       
       <!-- 부트스트랩은 트위터에서 사용하는 각종 레이아웃, 버튼, 입력창 등의 디자인을 CSS와 JavaScript로 만들어 놓은 것이다.
       . Easy to use : HTML과 CSS 기본 지식을 가진 누구나 쉽게 접근 가능(+javascript)
       . Responsive features : 반응형 CSS를 포함한 단일코드로 모든 디바이스에 적용할 수 있음
       
       부트스트랩의 CSS와 JavaScript,관련 이미지만 설치하고 미리 지정된 CSS 클래스나 JavaScript 함수만 불러오면 트위터에서 쓰는 것과 비슷한 디자인이 뚝딱 만들어진다.
        -->
<title>회원 업데이트</title>
</head>
<body>
<script type ="text/javascript">
$(document).ready(function(){
    
    
    $(".cencle").on("click", function(){
       location.href="/";
    })
    
    $("#submit").on("click", function(){
       
       if($("#userPass").val()==""){
          alert("비밀번호를 입력해주세요");
          $("#userPass").focus();
          return false;
       }
       if($("#userName").val()==""){
          alert("성명을 입력해주세요");
          $("#userName").focus();
          return false;
       }
    });
 });
</script>
</body>
	<section id = "container">
		<form action = "/member/memberUpdate" method = "post">
			<div class = "form-group has-feedback">
				<label class = "control-label" for = "userId">아이디</label>
				<input class = "form-control" type = "text" id = "userId" name = "userId" value = "${member.userId}" readonly = "readonly"/>
			</div>
			<div class = "form-group has-feedback">
				<label class = "control-label" for = "userPass">패스워드</label>
				<input class = "form-control" type = "password" id = "userPass" name = "userPass"/>
			</div>
			<div class = "form-group has-feedback">
				<label class = "control-label" for = "userName">성명</label>
				<input class = "form-control" type = "text" id = "userName" name = "userName" value = "${member.userName}"/>
			</div>
			<div class = "form-group has-feedback">
				<button class="btn btn-success" type = "submit" id = "submit">회원정보수정</button>
				<button class="cencle btn btn-danger" type = "button">목록이동</button>
			</div>	
		</form>
	</section>
</html>