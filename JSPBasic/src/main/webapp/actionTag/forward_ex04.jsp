<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    /* request.getParameter(arg0); */
    
    //중간에 setAttribute로 저장한 데이터는 getAttribute로 사용
    String name = (String)request.getAttribute("name");
    
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>포워드 04 페이지</h3>
	서블릿에서 날아온 데이터: <%=name %>
	<p></p>
</body>
</html>