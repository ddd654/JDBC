<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 톰캣 10버전은 서블릿이 jakarta 서블릿으로 변경 > jstl도 jakarta버전으로 쓴다 -->
	<!-- 톰캣 9버전은 javax 서블릿이여서 일반으로 다운 -->
	
	<!-- jstl은 메이븐 리포지토리에서 다운해서 lib에 넣고 사용해준다 -->

	<h3>jstl if문 확인하기</h3>

	<form action="jstl_if.jsp" method="post">
		이름: <input type="text" name="name">
		나이: <input type="number" name="age">
		 <input type="submit" value="확인">
		
	
	</form>
	
	<h3>choose문 확인하기</h3>
	<form action="jstl_choose.jsp" method="post">
		이름: <input type="text" name="name">
		나이: <input type="number" name="age">
		 <input type="submit" value="확인">
		
	
	</form>

</body>
</html>