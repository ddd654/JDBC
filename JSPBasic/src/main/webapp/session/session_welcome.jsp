<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	//로그인 안한 사람은 접근 못하게
	if( session.getAttribute("id") == null){
		response.sendRedirect("session_ex01.jsp");
	}
	
	
	//세션에 저장된 값을 얻는다.
	String id = (String)session.getAttribute("id");
    String nick = (String)session.getAttribute("nick");
	
	
	%>
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=id%>님 환영합니다
	
	<a href="session_logout.jsp">logout</a>
</body>
</html>