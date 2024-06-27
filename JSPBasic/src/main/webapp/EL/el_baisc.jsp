<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	EL 사용하기
	<br>
	<%= 1 + 2%> <br>
	${1+2 } <br>
	${1>2 } <br>
	${2 ==2 } <br>
	${1 == 2 ? '같은' : '다름' } <br>
	${1 < 2 && 2 < 3 } <br>
	${1 < 2 || 2 < 3 } <br>
	${'홍길동' == '홍길동' } <br>
	${!false } <br>
 	
	<br>
	+직관적인 연산자도 제공된다 <br>
	${'사과' eq '사과' } <br>
	${1 < 2 and 2 < 3 } <br>
	${1 < 2 or 2 < 3 } <br>
	
	${not false } <br>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>