<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>경로 공부</h3>
	
	<!-- a태그로 jspTag 폴더에 include페이지로 상대경로, 절대경로로 이동하기 -->
	<a href="../../JspTag/include.jsp">include 페이지 </a>
	<a href="/JSPBasic/JspTag/include.jsp">include 페이지</a>
	
	<br>
	<!-- MrServlet 경로는 /JSPBasic/apple 상대경로로 이동하기 -->
	<a href="../../apple">MyServlet 상대</a> ???
	<a href="/JSPBasic/apple">MyServlet 절대</a>
	
	<br>
	<!-- html 안에 있는 이미지 파일을 img태그 상대경로, 절대경로 참조 -->
	<a href="../../html/img/sun.jpg"><img alt="" src="../../html/img/sun.jpg"></a>
	<a href="/JSPBasic/html/img/flower.jpg"><img alt="" src="/JSPBasic/html/img/flower.jpg"></a>
	
</body>
</html>