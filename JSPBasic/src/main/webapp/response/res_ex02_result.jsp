<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// 2.아이디가 abc이고, 비밀번호가 1234, 로그인 성공이라고 가정하고 ex02_success로 이동
// 3. 아이디, 비밀번호가 틀린경우 ex02_fail페리지로 리다이렉트 시키기

//
request.setCharacterEncoding("utf-8");

// 받은 아이디 비밀번호
// request response out session application
String id = request.getParameter("id");
String pw = request.getParameter("pw");

if (id.equals("abc") && pw.equals("1234")) {
	//로그인 성공
	response.sendRedirect("res_ex02_success.jsp");
} else {
	//로그인 실패
	response.sendRedirect("res_ex02_fail.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	id: <%=id %>
	
	
</body>
</html>