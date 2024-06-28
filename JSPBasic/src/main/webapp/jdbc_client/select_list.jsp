<%@page import="com.myweb.model.DepartmentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
// select_list 페이지에서 조회한 결과를 얻는다
// ArrayList<DepartmentDTO> list = (ArrayList<DepartmentDTO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	부서수:
	<%-- <%=list.size()%> --%>
	바뀐 부서수: ${fn:length(list) }


	<h3>부서 데이터</h3>
	<table>
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>매니저번호</th>
			<th>부서위치번호</th>
		</tr>

		<!-- 바뀐 반복문으로 해보기 -->
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.departmentId }</td>
				<td>${dto.departmentName }</td>
				<td>${dto.managerId }</td>
				<td>${dto.locationId }</td>
			</tr>

		</c:forEach>

		<%-- <%-- 
		<!-- 리스트 길이만큼 반복 -->
		<%
		for (DepartmentDTO dto : list) {
		%>
		<tr>
			<td><%=dto.getDepartmentID()%></td>
			<td><%=dto.getDepartmentName()%></td>
			<td><%=dto.getManagerId()%></td>
			<td><%=dto.getLocationId()%></td>
		</tr>

		<%
		}
		%> --%> 


	</table>







</body>
</html>