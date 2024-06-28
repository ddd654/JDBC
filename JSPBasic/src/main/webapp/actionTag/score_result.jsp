<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

<%
	/*
	앞에서 넘어온 폼값을 받아서 평균을 구합니다.
	평균이 60점 이상이면 score_ok으로 이동해서
		~~님 평균은 xx점 합격입니다 를 출력
	평균이 60점 이하라면 score_no으로 이동해서
		~~님 평균은 xx점 불합격입니다 를 출력
		
	조건: 세션을 사용하지 않습니다.		
	*/
	//String name = (String) request.getAttribute("name");
 	
	String name1 = request.getParameter("name");

	//값 폼에서 가져오기
	String lang = request.getParameter("lang");
	String eng = request.getParameter("eng");
	String math = request.getParameter("math");

	// 변환
	int lang1 = Integer.parseInt(lang);
	int eng1 = Integer.parseInt(eng);
	int math1 = Integer.parseInt(math);
	
	double avg = (lang1 + eng1 + math1)/3; 
	
	//
	request.setAttribute("avg", avg);
	
	//평균 조건
	// 나중에 sendRedirect 해보기
	if(avg >= 60){
		request.getRequestDispatcher("score_ok.jsp").forward(request, response);
	} else {
		request.getRequestDispatcher("score_no.jsp").forward(request, response);

	}
	
	
	
	
	
	
%>
	포워드로 다음 페이지로 데이터 보내기
	<jsp:forward page="score_ok.jsp">
    	<jsp:param value="<%=name1 %>" name="name"/>
    	<jsp:param value="<%=avg %>" name="avg"/>
    </jsp:forward>
