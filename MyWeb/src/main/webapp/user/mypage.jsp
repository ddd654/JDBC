<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%@ include file ="../include/header.jsp" %>
  	
  	
  	
<section>
	<div align="center">
		
		<h3>${sessionScope.user_name }회원(${sessionScope.user_id }) 님의 회원정보를 관리합니다.</h3>
		
		<a href="modify.user">회원정보 관리</a>
		<a href="delete.user">회원탈퇴(화면으로)</a>
		
 		
 		<form action="modify.jsp" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" placeholder="4글자 이상" value="${dto.id }" required="required"></td>
				</tr>			
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="pw" placeholder="4자 이상" value="${dto.pw }" required="required"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="이름" value="${dto.name }" required="required"></td>
				</tr>			
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="${dto.email }"></td>
				</tr>
				<tr>
					<td>남? 여?</td>
					<td>
						<input type="radio" name="gender" value="M" ${dto.gender == 'M' ? 'check' : '' }>남자
						<input type="radio" name="gender" value="F" ${dto.gender == 'F' ? 'check' : ''  }>여자
					</td>
				</tr>			
			
			</table>
			
			<br/>
			<input type="submit" value="수정">
			<input type="button" value="로그인" onclick="location.href='mypage.user';">
			
			
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