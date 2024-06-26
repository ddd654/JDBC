<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    //쿠키를 꺼냄
    Cookie[] cookies = request.getCookies();
    
    String str= "";
    
    if(cookies != null){
    	for(Cookie c : cookies){
    		//user_id 쿠키가 있는지 확인하기
    		if(c.getName().equals("user_id")){//true면 쿠키 있음
    			str = c.getValue();	
    		}
    		
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
	user_id 쿠키값: <%= str %>
</body>
</html>