package com.MVC2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//서블릿 만들기, 여기가 프론트컨트롤러
//1. 확장자 패턴을 *.do 로 자주 표현한다
@WebServlet("*.test") // http://localhost:8181/JSPBasic/wwdw.test 그 후 아무 주소나 적어도 goGet메서드가 실행된다
public class TestController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public TestController() {
		
	}

	
	//2. get요청, post 요청을 하나로 모은다
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {

		System.out.println("서블릿 실행함");
		doAction(request, reponse);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		doAction(request, reponse);

		
		
	}
	
	//2. 복사해서 새로운 메서드 만들기, doAction()을 받도록 위에 추가
	protected void doAction(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		
		//3 요청을 분기
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI(); //ip, port번호 제외된 주소
		String path = request.getContextPath(); // 프로젝트 식별 주소
		String command=uri.substring(path.length());
		
		System.out.println(command); //요청 되는지 눈으로 보게
		
		//controller.jsp 로 이동 
		
		if(command.equals("/controller/signup.test")) {
			//회원가입 요청처리
			
		}else if (command.equals("/controller/login.test")) {
			//로그인 요청처리
		}
		
		
		
	}
	
}
