<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<%@include file="../include/header.jsp" %>


<!-- 25) dto가 화면에 도착해 있음 -->
<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${dto.bno }</td>
			
			<td width="20%">조회수</td>
			<td width="30%">${dto.hit }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.writer }</td>
			
			<td>작성일</td>
			<td >${dto.regdate}</td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${dto.title }</td>	
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${dto.content }</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
			<!-- 26) 경로 지정후 컨트롤러로 화면을 불러온다 -->
				<input type="button" value="목록" onclick="location.href='list.board';">&nbsp;&nbsp;
				
				<c:if test="${dto.writer == sessionScope.user_id }">
				<!-- 31) bno=${dto.bno} 경로 지정-->
				<input type="button" value="수정" onclick="location.href='modify.board?bno=${dto.bno}&writer=${dto.writer}';">&nbsp;&nbsp;
				
				<!-- 35) 삭제는 원래 post방식이 되어야하는데 이번만 get으로 한다 -->
				<input type="button" value="삭제" onclick="location.href='delete.board?bno=${dto.bno}&writer=${dto.writer }';">&nbsp;&nbsp;
				<!-- 0703
				작성자 보내기
				자기자신 글 수정할 수 있게 하는 과정
				
				c:if까지 하면 끝
				 -->
				 
				 </c:if>
			</td>
		</tr>
	</table>

</div>

<%@include file="../include/footer.jsp" %>

