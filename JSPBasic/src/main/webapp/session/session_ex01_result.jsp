<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //1. 아이디, 비밀번호, 닉네임 값을 받음
    //2. 아이디, 비번이 같으면 로그인 성공
    //닉네임과, 아이디를 저장하는 세션을 생성하고, session_welcome 페이지로 리다이렉트 시킨다
    //welcome 페이지에서는 "~~님 환영합니다" 표시
    // welcome 에서 로그아웃 태그 기능도 만들어보기
    
   /*  String id = "";
    String pw = "";
    String nick = "";
    session.setAttribute("id", id);
    session.setAttribute("pw", pw);
    session.setAttribute("pw", nick); */
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String nick = request.getParameter("nick");
    
    if(id.equals(pw)){
    	//세선에 아이디, 닉네임 저장
    	session.setAttribute("id", id);
    	session.setAttribute("nick", nick);
    	
    	//로그인 성공
        response.sendRedirect("session_welcome.jsp");
    } else {
        response.sendRedirect("session_ex01.jsp");
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