<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!--method = "post" post방식으로 실행하기  -->

	<h2>post방식 form이 꼭 필요하다 보안에 좋음</h2>
	
	<form action="req_post_ex02.jsp" method = "post">
		아이디:<input type="text" name="id">
		비밀번호:<input type="password" name= "pw">
	
		<input type="submit" value="로그인">
		
	</form>

</body>
</html>