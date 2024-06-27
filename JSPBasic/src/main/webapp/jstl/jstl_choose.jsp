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

	<h3>if else 같은 문장</h3> 
	<c:choose>
		<c:when test="${param.name == '사과' }">
			<p>맛있는 사과</p>
		</c:when>

		<c:when test="${param.name == '바나나' }">
			<p>맛난 바나나</p>
		</c:when>
		<c:otherwise>
			<p>둘다 아닙니다</p>
		</c:otherwise>


	</c:choose>


	<!-- 20세 이상이면 성인, 20세 미만이면 미성년자 choose -->

	<c:choose>
		<c:when test="${param.age >= 20}">
			<p>성인</p>
		</c:when>

		<c:otherwise>
			미성년자
		</c:otherwise>


	</c:choose>

</body>
</html>