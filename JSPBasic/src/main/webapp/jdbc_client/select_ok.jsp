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

	<c:if test=" ${list == null }">
		<p>없는 부서</p>
	</c:if>
	
	<a href="quiz01.jsp">다시 조회하기</a>

	<table>

		<!-- 행 이름은 하나 -->
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>매니저번호</th>
			<th>위치번호</th>
		</tr>
		
	<%-- 	
		<tr>
			<th>${quiz.departmentId }</th>
			<th>${quiz.departmentNama }</th>
			<th>${quiz.manegerId }</th>
			<th>${quiz.locationId }</th>
		
		</tr> 
	--%>

		<!-- 열이 여러개 반복출력 -->
		<c:forEach var="quiz" items="${list }">
			<tr>
				<td>${quiz.departmentId }</td>
				<td>${quiz.departmentName }</td>
				<td>${quiz.managerId }</td>
				<td>${quiz.locationId }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>