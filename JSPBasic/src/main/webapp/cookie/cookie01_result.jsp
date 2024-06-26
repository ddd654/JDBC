<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String y = request.getParameter("y");
    
    //id, pw가 같으면 로그인 성공이라고 가정
    if(id.equals(pw)){
    	//1. 로그인에 활용할 쿠키(로그인을 성공하면 쿠키 만듬)    	
    	Cookie cookie = new Cookie("user_id", id); //이름, 값
    	cookie.setMaxAge(1800); //30분
    	response.addCookie(cookie); //쿠키담기
    	
    	//2. 아이디기억하기
    	//사용자가 아이디 기억하기 쿠키가 있다면, input 태그에 value값을 찍어주세요
    	if(y!= null){
    	Cookie value = new Cookie("value", y);
    	cookie.setMaxAge(1000);
    	response.addCookie(value);
    	
    	
    		
    	}
    	
    	
    	response.sendRedirect("cookie01_welcome.jsp");
    	
    } else {
    	// 다시 로그인 창으로
    	response.sendRedirect("cookie01.jsp");

    }
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	

</body>
</html>