<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    <%
    
    String s = request.getParameter("point");
    String name = request.getParameter("name");
    %>

    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	포워드로 넘어온 데이터<%=s %> <br>
	중간에 넣은 데이터<%=name %>
</body>
</html>