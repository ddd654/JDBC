<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//쿠키 생성 문법
	//1. 쿠키 만들기
	Cookie cookie = new Cookie("user_id", "aaa123"); // 둘다 String 이다
	Cookie cookie2 = new Cookie("user_name", "사과");
	
	//2. 쿠키 지속시간
	cookie.setMaxAge(3600); // 1시간
	cookie2.setMaxAge(20); // 20초
	//3. 쿠키를 response에 담아서 보낸다
	response.addCookie(cookie);
	response.addCookie(cookie2);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키</h3>

	<p>서버와 클라이언트의 정보 유지 수단으로 서버에서 만들어 클라에 저장한다</p>
	
	<a href="cookie_get.jsp">쿠키</a>
</body>
</html>