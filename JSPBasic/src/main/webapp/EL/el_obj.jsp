<%@page import="com.myweb.model.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    //setAttribute로 req에 저장
    //request.setAttribute("email", "aaa@naver.com");
    //쓰려면 getAttribute가 필요했는데 el로 사용가능하다
    
    
    
    DepartmentDTO dto = new DepartmentDTO();
    dto.setDepartmentID(100);
    dto.setDepartmentName("IT");
    
    request.setAttribute("dto", dto);
    
    
    
    // el 다시해보기
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>setAttribute로 저장된 값을 el로 사용해보기</h3>
	
	<%-- ${requestScope.email } <br> --%>
	${requestScope.dto.departmentId } <br>
	${requestScope.dto.departmentName } <br>
	
	보통 requestScope는 많이 생략함 <br>
	
	
</body>
</html>