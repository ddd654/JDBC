<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>req_quiz_ok로 post 방식으로 데이터를 넘기고, ok페이지에서는 화면에 출력</h3>
		<!-- post방식 적용  -->
	
	<form action="req_quiz_ok.jsp" method="post">	
	
	
		아이디:<input type="text" name="id" placeholder="hint" size="8"><br>
		비밀번호:<input type="password" name="pw"><br>
		
		<!-- checkbox, radio속성도 name을 사용해서, 하나의 그룹으로 묶어준다 -->
		관심분야:
		<input type="checkbox" name="inter" value="java"> java
		<input type="checkbox" name="inter" value="jsp">jsp
		<input type="checkbox" name="inter" value="data">database <!-- ctrl alt 아래로 복사 -->
		<input type="checkbox" name="inter" value="python">python
		<br>
	
		전공분야:
		<input type="radio" name="major">경영학과
		<input type="radio" name="major">컴퓨터공학과
		<input type="radio"  name="major">철학과
		<input type="radio" name="major">수학과
		<br>

		입사일
		<input type="date" name="regdate">
		
		<br>
		<select name="region">
			<option>서울시</option>
			<option>경기도</option>
			<option>부산시</option>
			<option>인천시</option>
		
		</select>
		
		<br>
		자기소개:<br>
		<textarea rows="5" cols="30" name="intro"></textarea>
		
		<br>
		<!-- form안의 데이터를 서버로 전송하는 submit 버튼 -->
		<input type="submit" value="확인">
		<input type="reset" value="다시작성하기"> <!-- 폼안의 값을 리셋한다 -->
		
		<!-- 나중에 js로 기능을 붙이게 된다 -->
		<input type="button" value="버튼1">
		
	
	</form>
	
</body>
</html>