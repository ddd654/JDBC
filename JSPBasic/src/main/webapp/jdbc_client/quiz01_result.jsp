<%@page import="oracle.jdbc.driver.json.parser.JsonParserImpl"%>
<%@page import="com.myweb.model.Quiz_DTO"%>
<%@page import="com.myweb.model.Quiz_DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myweb.model.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	사용자가 부서번호에 정보를 보여주는 프로그램 코드
	입력한 부서번호의 정보를 보여주는
	
	1. 사용자가 입력한 부서번호를 받습니다.
	
	2. DepartmentDAO에 부서번호에 따라서 부서정보를 조회하는 메서드를 생성해주세요.
		=> 번호로 조회하기 때문에 부서번호는 반드시 1행 입니다.
		
	3. 부서정보를 조회했다면, 조회한 결과를 quiz_ok로 데이터를 넘겨주세요.
	4. quiz_ok에서는 EL, JSTL을 사용해서, 사용자의 부서정보를 출력해주면 됩니다.
		
	*/
	
	String name = (String) request.getParameter("departmentId");
	int departmentId = Integer.parseInt(name);

	Quiz_DAO dao = Quiz_DAO.getInstance();
	ArrayList<Quiz_DTO> list = dao.getList(departmentId); //메서드 호출
	
	request.setAttribute("list", list);
	
	//포워드 이동
	request.getRequestDispatcher("select_ok.jsp").forward(request, response);
	
	
	/* //---------
	//DAO생성
	Quiz_DAO dao2 =Quiz_DAO.getInstance();
	Quiz_DTO dto = dao.getDept(dno); //메서드 호출
	
	//dto를 quiz_ok로 넘긴다
	request.setAttribute("dto", dto);
	request.getRequestDispatcher("quiz_ok.jsp").forward(request, response); */
	
%>
<h3>조회할 부서번호</h3>
	<form action="quiz01_result.jsp" method="post">
		<input type="number" name="departmentId">
		<input type="submit" value="확인" >
	</form>