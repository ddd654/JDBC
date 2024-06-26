<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    //application 내장객체는 session 사용문법은 동일
    // 생명주기가 was를 시작할때 전역에서 단 1개 생성됩니다.
    //프로그램 전역에서 사용할 값들을 저장해놓을 수 있습니다
    
    int total = 0;
    
    //application객체에 값이 있으면 가져옴
    if(application.getAttribute("total") != null){
    	total = (int)application.getAttribute("total");
    }
    
    total++;
    
    application.setAttribute("total", total);
    
    //값의 사용
    //int result = (int)application.getAttribute("total");
    
    //application 객체는 서버를 끌때까지 유지됨
   	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과 : <%=total %>
<%-- 	주소 : <%=remote %>
	<% if(total == 77){ %>
	<p>축하드립니다</p>
	<% }%>
	 --%>
</body>
</html>