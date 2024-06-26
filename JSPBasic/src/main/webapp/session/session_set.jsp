<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //세션은 쿠키와 비슷하게 서버와 정보를 지속적으로 유지하기 위해서 사용됨
    //서버가 생성하고, 관리하기 때문에 중요한 정보를 적어도 된다
    
    //세션에 저장하기
    session.setAttribute("user_id", "aaa123"); //찾아 쓸 값은 왼쪽값
    session.setAttribute("user_name", "홍길동");
    
    //세션은 기본 30분으로 설정되있음 - 톰캣에
    session.setMaxInactiveInterval(3600); // 1시간으로 설정
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="session_get.jsp">세션 값 확인하기</a>

</body>
</html>