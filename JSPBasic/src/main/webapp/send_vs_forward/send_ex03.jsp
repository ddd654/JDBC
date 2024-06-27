<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%    String point = request.getParameter("point");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	sendRedirect로 넘어온 데이터<%=point %>
	
	리다이렉트로 보내면 포워드와 다르게 가져올수 없다
</body>
</html>