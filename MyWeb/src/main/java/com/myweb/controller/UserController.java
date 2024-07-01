package com.myweb.controller;

import java.io.IOException;

import com.myweb.userService.UserService;
import com.myweb.userService.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("*.user")// 확장자 패턴 이쪽으로 다 받겠다
public class UserController extends HttpServlet{
	
	public UserController() {
		
	}

	//doAction으로 연결
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);

		
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//3 요청을 분기
		
				request.setCharacterEncoding("utf-8");
				
				String uri = request.getRequestURI(); //ip, port번호 제외된 주소
				String path = request.getContextPath(); // 프로젝트 식별 주소
				String command=uri.substring(path.length());
				
				System.out.println(command); //요청 되는지 눈으로 보게
				
				//controller.jsp 로 이동 
				
				UserService service;
				
				
				//원래 기본 이동방식으 포워드로 한다
				//회원가입 화면
				if(command.equals("/user/join.user")) {
					//회원가입 화면
//					response.sendRedirect("join.jsp");
					request.getRequestDispatcher("join.jsp").forward(request, response);
					
					
				}else if (command.equals("/user/joinForm.user")) {
					//회원가입 기능
					
					//값넣기
					service = new UserServiceImpl(); //수정할 부분
					service.join(request, response);
					
				} else if(command.equals("/user/login.user")) {
					
					//로그인화면으로 가게 하기
//					response.sendRedirect("login.jsp");
					request.getRequestDispatcher("login.jsp").forward(request, response);

					//
					
				} else if(command.equals("/user/loginForm.user")) { //로그인 요청하기
					
					service = new UserServiceImpl();
					service.login(request, response);
					
				} else if(command.equals("/user/mypage.user")) { // 회원페이지에 왔으면
					request.getRequestDispatcher("mypage.jsp").forward(request, response);
					
				} else if(command.equals("/user/modify.user")) {
					//회원정보 수정페이지로 간다
					
					service = new UserServiceImpl();
					service.getInfo(request, response);
					
					
				} else if(command.equals("/user/logout.user")) {
					
					HttpSession session = request.getSession();
					session.invalidate();
					
					response.sendRedirect(request.getContextPath() + "/index.jsp"); //메인화면으로 간다
					
				} else if(command.equals("/user/update.user")) {
					//회원정보 수정 화면
					
					service = new UserServiceImpl();
					service.update(request, response);
				} else if (command.equals("/user/delete.user")) {
					
					//삭제 화면 만들기
					//mvc2는 기본이동이 포워드
					request.getRequestDispatcher("delete.jsp").forward(request, response);
					
					//이제 화면을 만들어야 한다 jsp로
					
				} else if (command.equals("/user/deleteForm.user")) {
					//탈퇴화면으로
					
					
					service = new UserServiceImpl();
					service.delete(request, response);
				}
				
				
				
				
//				else if(command.equals("/user/modify.user")) {
//					request.getRequestDispatcher("modify.jsp").forward(request, response);
//					
//					
//				}
				
				
	}
	
	
	
	
}
