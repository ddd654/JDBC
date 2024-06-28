<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	변수
	<br>
	<c:set var="a" value="10" />

	출력
	<br>
	<c:out value="${a }"></c:out>

	<hr>
	<c:if test="${a >= 10 }">
		<p>실행되는 문장, 참</p>

	</c:if>

	<hr>
	<c:if test="${param.age >= 20}">
		<p>성인입니다</p>
	</c:if>



<%-- 	<%
	String age = request.getParameter("age");
	int x = Integer.parseInt(age);

	if (x >= 20){
	%>
	성인

	<%} --%> %>


	<hr>
	<c:if test="${param.name == '사과' }">
		<p>사과는 맛있어</p>
	
	</c:if>


<h3>jstl if문 확인하기</h3>

	<form action="jstl_choose.jsp" method="post">
		이름: <input type="text" name="name">
		나이: <input type="number" name="age">
		 <input type="submit" value="확인">
		
	
	</form>




</body>
</html>