<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    
    //사용자가 아이디기억하기를 체크했으면 쿠키가 있겠지
    Cookie[] cookie = request.getCookies();
    
    String id = "";
    if(cookie != null){
    	for(Cookie c: cookie){
    		if(c.getName().equals("value")){
    			id = c.getValue();
    			
    		}
    	}
    }
    
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- input 태그에 미리 값을 갖게할 수 있음 -->

	<h3>쿠키 활용하기</h3>
	
	<form action="cookie01_result.jsp" method="post">
		아이디: <input type= "text" name="id" value="<%=id %>">
		비밀번호: <input type= "password" name= "pw">
		
		<input type= "submit" value= "확인">
		<input type= "checkbox" value= "y" name="y">아이디기억하기
		
<!-- 		쿠키는 아이디 기억하는데 쓰일 수도 있다, 용도는 아님
 -->	
	</form>
	
	
</body>
</html>