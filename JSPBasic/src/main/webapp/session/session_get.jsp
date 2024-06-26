<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //세션은 한번 저장해 놓으면, 만료되기 전이나 브라우저를 끄기 전에
    // 아무데서나 사용된다
    
    String user_id = (String)session.getAttribute("user_id");
    String user_name = (String)session.getAttribute("user_name");
    
    
    //세션 값 삭제하기
    session.removeAttribute("user_name");
    
    //세션 값 초기
    session.invalidate(); // 실행하면 전체 값 초기화됨, ex) 로그아웃때
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	세션에 저장된 id : <%=user_id %><br>
	세션에 저장된 name : <%=user_name %>
</body>
</html>