package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward") //요청경로
public class forward_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public forward_servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//post요청에 대한 자바코드
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//콘솔에 나타내기
		System.out.println(id + ", " + pw);

		//id에 해당하는 유저 정보를 담라서 화면에 보내자
		//다른 페이지에서 사용할 1회성 데이터를 request에 중
		request.setAttribute("name", "사과");
		
		
		//자바에서 포워드 사용하는 방법
		RequestDispatcher dp =request.getRequestDispatcher("actionTag/forward_ex04.jsp"); //이동할 url 주소 넣기
		dp.forward(request, response);
		
		//서블릿을 거쳐서 04번으로 이동한다
		
		
		
		
		
		
		
		
	}
}