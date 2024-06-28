<%@page import="com.myweb.model.DepartmentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myweb.model.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    // 지금받은 값은 없다
    //DAO 객체 생성하기
    // new DepartmentDAO(); // << 이렇게 생성 못함
    
    DepartmentDAO dao =  DepartmentDAO.getInstance(); //싱글톤 객체 생성
    
    ArrayList<DepartmentDTO> list = dao.getList(); // 부서 조회 메서드 호출
    
    //리스트를 다음 페이지로 전달
    request.setAttribute("list", list); //request에 저장
    
    //포워드로 결과화면 이동
    request.getRequestDispatcher("select_list.jsp").forward(request, response);
    
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>