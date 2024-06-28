<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ include file="../include/header.jsp" %>
    
    
    
<!-- 메뉴를 누르면 컨트롤러에 보낸다  
	header에서 수정
-->

<section>


<!--
	required 공백 허용하지 않음
	readonly 읽기만 가능하다
	disabled 태그를 사용하지 않음
	checked 체크박스에서 미리 선택되있음
	selected 셀렉트태그에서 미리선택

  -->
	
	<div align="center">
		
		<h3>노름은 파도고, 프로그램은 data flow다</h3>
		
		<hr/>
		
		<form action="joinForm.user" method="get">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" placeholder="4글자 이상" required="required"></td>
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
						<input type="radio" name="gender" value="M">남자
						<input type="radio" name="gender" value="F">여자
					</td>
				</tr>			
			
			</table>
			<!-- 이미 존재하는 회원입니다 표시하는 메시지 -->
			
			${msg }
			
			<br/>
			<input type="submit" value="가입">
			<input type="button" value="로그인" onclick="location.href='login.user';">
			
			
		</form>
		
		
	
	</div>
	

</section>
    
    
<%@ include file="../include/footer.jsp" %>