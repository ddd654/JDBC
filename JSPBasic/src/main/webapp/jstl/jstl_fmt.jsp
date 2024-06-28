<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 특정 태그를 쓸 수 있게 해줌 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>fmt라이브러리는 주로 형변환하는데 사용된다</h3>

	<h3>parseNumber, paseDate, formatNumber, formarDate</h3>

	parse >> 데이터 타입을 변경
	<br> format >> 데이터 출력형식을 바꾼다
	<br>

	<h3>formatNumber 는 숫자의 표현 형식을 바꾼다</h3>

	<c:set var="a" value="2024"></c:set>

	변수 비우면 바로 출력된다
	<fmt:formatNumber value="${a }" pattern="0000000"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="${a }" pattern="0000000.00"></fmt:formatNumber>
	<br>

	<h3>formatDate 는 날짜의 표현 형식을 바꿈</h3>

	<c:set var="b" value="<%=new Date()%>"></c:set>

	<fmt:formatDate value="${b }" pattern="yyyy년 MM월 dd일 HH:mm:ss" />
	<fmt:formatDate value="${b }" pattern="yyyy년 MM월 dd일 HH:mm:ss" />

	<hr>
	<h3>parseNumber는 문자를 숫자로 변환</h3>
	<c:set var="c" value="1.100"></c:set>
	<fmt:parseNumber value="${c }" pattern="0.000"></fmt:parseNumber>

	<h3>parseDate 문자를 날짜로 변환</h3>
	<c:set var="d" value="2024-06-27"></c:set>
	<fmt:parseDate var="result" value="${d }" pattern="yyyy-MM-dd" />

	${result }

	<hr>
	<h4>아래값을 년월일 시분초 형식으로 만들기</h4>
	<c:set var="e" value="2020-05-03 11:22:33"></c:set>
	<c:set var="f" value="<%=new Date() %>"></c:set>
	
	
	<fmt:parseDate var="aa" value="${e }" pattern="yyyy-MM-dd HH:mm:ss"/>
	<fmt:formatDate var="bb" value="aa" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/>
	
	${aa } <br>
	${bb }
	

</body>
</html>