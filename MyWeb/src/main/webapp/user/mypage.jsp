<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%@ include file ="../include/header.jsp" %>
  	
  	
  	
<section>
	<div align="center">
		
  		<div>
  			<h3>
  			 ${sessionScope.user_name }회원 (${sessionScope.user_id })님의 회원정보 관리
  			</h3>
  		
  		</div>
  		
		<h3>노름은 파도고, 프로그램은 data flow다</h3>
		
		<a href="modify.user">회원정보 관리</a>
		
  			<a>회원탈퇴</a>
		<hr/>
		
		<form action="joinForm.user" method="get">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" placeholder="4글자 이상" readonly="readonly"></td>
				</tr>			
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="pw" placeholder="4자 이상"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="이름"></td>
				</tr>			
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>남? 여?</td>
					<td>
						<input type="radio" name="gender" value="M" checked="checked">>남자
						<input type="radio" name="gender" value="F">여자
					</td>
				</tr>			
			
			</table>

			
			<br/>
			<input type="submit" value="수정하기">
			<input type="button" value="취소" onclick="location.href='mypage.user';">
			
			
		</form>
		
		
	
	</div>
	

</section>
    <%@ include file ="../include/footer.jsp" %>
    
    
    
    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>