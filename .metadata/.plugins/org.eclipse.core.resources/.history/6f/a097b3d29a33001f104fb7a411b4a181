<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8"); //한글나오게
	
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	if(age >= 20){
		//response
		response.sendRedirect("res_ex01_ok.jsp");
	} else {
		response.sendRedirect("res_ex01_no.jsp");
	}
	

//자바 코드만 있어서 서블릿으로 변경가능
%>