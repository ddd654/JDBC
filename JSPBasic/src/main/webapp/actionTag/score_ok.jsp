<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%   
    String name = request.getParameter("name");

    double avg = (double)request.getAttribute("avg");
    
/*     String avg = request.getParameter("avg");
    
    int avg1 = Integer.parseInt(avg); */

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- <% if(avg1 >= 60){ %>
		평균: <%=avg1 %>점 합격
		
	<% } else {%>
	
		평균: <%=avg1 %>점 불합격
		
	<% }%> --%>
	
	
	합격
	<%=avg %>
	
	
	
	
		

</body>
</html>