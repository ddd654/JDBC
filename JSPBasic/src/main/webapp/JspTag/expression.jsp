<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Queue"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	//이 페이지에서 전체적으로 사용할 변수는 이렇게
	
	//컬렉션
	List<String> list = new ArrayList<>();
	
	list.add("사과");
	list.add("바나나");
	list.add("자두");
	
	
	//큐
	Queue<Integer> queue = new LinkedList<>();
	queue.offer(1);
	queue.offer(2);
	queue.offer(3);
	//poll
	
	//맵
	Map<Integer, String> map = new HashMap<>();
	map.put(1, "사과");
	map.put(2, "사과");
	// get(key)
	
	
	//셋
	Set<Integer> set = new HashSet<>(); 
	set.add(1);
	set.add(2); //중복안됨, 순서 없음
	
%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>구구단 3단 out.println</h3>

	<%
	for(int i = 1; i <= 9; i++){
		out.println(3 + "x" + i + "=" + i*3 + "<br>");
	}
	
	%>

	<% for(int i =1; i <= 9; i++){ %>
	 	<!-- html -->
		 
		3 x <%= i %> = <%=i*3 %> <br>
		 	
	<% } %>
	
	<h3>체크박스에 1~20까지 숫자를 붙여서 가로로 출력</h3>
	<% for(int i = 1; i <= 20; i++){ %>
		<input type="checkbox" name="box"> <%=i %>
		
	<% } %>
	
	<h3>전체 구구단을 표현식으로 출력</h3>
	<% for(int i = 2; i <= 9; i++){%>
		
		<%for(int j = 1; j <= 9; j++){%>
			<%=i %> x <%=j %> = <%=i * j %> <br>
			
		<% } %>
		
	<% } %>
	
	<%-- 주석은 ctrl shift / --%>
	
	
	
	
</body>
</html>