<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>

<section>

	<div align="center">

		<h3>로그인</h3>
		<hr />
		<!-- 컨트롤러로 -->
		<form action="loginForm.user" method="post">
			<input type="text" name="id" placeholder="아이디">
			<input type="password" name="pw" placeholder="비번">
			
			
			<!-- 아이디와 비밀번호를 확인하세요 -->
			<br>
			${msg }
			
			<br/>
			<input type="submit" value="로그인">
			<a href="join.user">회원가입</a>
		
		</form>
	</div>

</section>

<%@ include file="../include/footer.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>