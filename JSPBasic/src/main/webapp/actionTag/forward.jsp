<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	액션테그 - 추가적으로 종속되는 태그가 없으면 끝부분을 /> 마감처리 합니다.
	 -->
	 
	 <jsp:forward page="forward_ex02.jsp" />
	 
	 <!-- redirect와는 다르다
	 포워드는 request 값을 다음에서도 사용할 수 있다
	 
	  -->
	 
</body>
</html>