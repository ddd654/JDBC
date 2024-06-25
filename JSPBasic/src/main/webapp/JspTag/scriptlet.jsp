<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- scriptlet으로 자바코드를 넣을 수 있다-->
	<% 
	//자바코드 쓰는 곳
	
	int a = 1;
	if(a >= 10){
		System.out.println("참");
		out.println("참");
	} else {
		System.out.println("거짓");
		out.println("거짓");

	}
	
	%>
	
	<hr>
	<%
		for(int i = 1; i<=10; i++){
			out.println(i + "<br>"); // 브라우저에서 태그로 인식한다
		}
	%>
	
	<hr>
	
	<%
		if(a >= 10){
			out.println("<a href ='#'>참</a>");
		} else {
			out.println("<a href ='#'>거짓</a>");

		}
	
	%>
	
	<hr>
	<!-- 이런식으로 스크립트릿으로 표현가능 -->
	<% if(a >= 10){ %>
		<a href="#">참</a>
	<% } else { %>
		<a href="#">거짓</a>
	<% } %>
	
	
	
	<!-- expression -->
	<hr>
	
	
	
	
	
	
	
	
	
	<!-- directive -->
	
</body>
</html>