<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String name= request.getParameter("name");
    String tall= request.getParameter("tall");
    String weight= request.getParameter("weight");
    
    
    double tall1 = Double.parseDouble(tall);
    double weight1 = Double.parseDouble(weight);
    
    // 정수 * 정수 > 정수 
	double bmi = weight1 / (tall1/100 * tall1/100);

    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>퀴즈2</h3>
	
	
	
	이름:<%=name %> <br>
	키:<%=tall %> <br>
	몸무게:<%=weight %> <br>
	BMI:<%if(bmi >=25){%>
		<p>과체중</p>)
		<% } else if(bmi <= 18){ %>
		<p>저체중</p>
		<%} else{ %>
		<p>정상</p>
		<%} %>
</body>
</html>