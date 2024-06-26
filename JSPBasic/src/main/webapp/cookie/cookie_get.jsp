<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    //쿠키 확인하기, 쿠키 꺼내기
    Cookie[] cookies= request.getCookies(); // 쿠키 꺼내기
    //쿠키 누른 순간 요청
    
    
    //쿠키 배열리 null이 아닌경우에만 실행
    if(cookies != null){
    	
    	for(Cookie c : cookies){
    		out.println(c.getName() + "<br>");
    		out.println(c.getValue() + "<br>");
    		out.println(c.getPath());
    	
    	}
    }
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 사용해보기</h3>
	<p>쿠키는 요청할때마다 자동으로 전송되어 request 객체에 저장됨</p>
	
	<a href="cookie_get2.jsp">특정 쿠키만 사용하기</a>
</body>
</html>