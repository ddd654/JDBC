<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="../include/header.jsp" %>
    
    
    
    <section>

		
<!--
	required 공백 허용하지 않음
	readonly 읽기만 가능하다
	disabled 태그를 사용하지 않음
	checked 체크박스에서 미리 선택되있음
	selected 셀렉트태그에서 미리선택

  -->
  
  <!-- 4. 이 화면에 dto가 있다
  값 정리 후 수정을 누르면 update.user로 보내주겠다
  컨트롤러로 사서 수정
   -->
	<div align="center">
		
		${dto }
		<p>apple</p>
		<hr/>
		
		<form action="update.user" method="post">
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
		
		<p></p>
		
	</div>
	

</section>
    
    
    <%@ include file="../include/footer.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>