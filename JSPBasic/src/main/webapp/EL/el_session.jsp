<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    //세션에 값을 저장
    session.setAttribute("user_id", "aaa123");
    session.setAttribute("user_name", "사과");
    
    application.setAttribute("menu", new String[]{"사과, 바나나"});
    %>
    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	sessionScope도 생략 가능함 <br>
	${sessionScope.user_id } <br>
	${sessionScope.user_name } <br>
	
	${applicationScope.menu[0] }
	
	<!-- sessionScope, applicationScope는 생략 안하고 쓰는편이다 -->
	<!-- 생략하면 request > session > application 순서로 이름값을 찾게된다 
		동일한 이름이 있으면 맨 앞에있는 request를 찾게되기 때문
	-->
	
	${user_id } <br>
	${ user_name } <br>

</body>
</html>