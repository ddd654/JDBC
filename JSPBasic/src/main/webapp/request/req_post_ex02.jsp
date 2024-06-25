<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
//한글처리하기
request.setCharacterEncoding("utf-8"); //request 사용 전에 인코딩형식 지정해야함

String id = request.getParameter("id");
String pw = request.getParameter("pw");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	아이디:<%=id %>
	비밀번호<%=pw %>
	
</body>
</html>