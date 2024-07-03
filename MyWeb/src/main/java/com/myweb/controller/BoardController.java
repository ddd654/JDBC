package com.myweb.controller;

import java.io.IOException;

import com.myweb.board.service.BoardService;
import com.myweb.board.service.BoardServiceImpl;
import com.myweb.userService.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("*.board") // .board로 끝나는 모든 요청은 서블렛으로 받기
public class BoardController extends HttpServlet {

	public BoardController() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);

	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청을 분기

		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI(); // ip, port번호 제외된 주소
		String path = request.getContextPath(); // 프로젝트 식별 주소
		String command = uri.substring(path.length());

		System.out.println(command); // 요청 되는지 눈으로 보게

		// 12. BoardService 선언해두기
		BoardService service;

		if (command.equals("/board/list.board")) {// 목록화면으로
			// mvc2의 기본이동은 포워드
			// request.getRequestDispatcher("board_list.jsp").forward(request, response);

			// 20. 서비스 영역을 거쳐서 목록 data를 가지고 감, 그래야 목록나옴
			service = new BoardServiceImpl();
			service.getList(request, response);
			// 23. 위처럼 만들어 겟리스트 가져옴

		} else if (command.equals("/board/write.board")) {// 글 작성화면으로 연결
//필터 테스트
//			//세션이 있나 없나로 글작성페이지 진입
//			HttpSession session = request.getSession();
//			String user_id = (String) session.getAttribute("user_id");
//			
//			if(user_id == null) {
//				response.sendRedirect("/MyWeb/index.jsp");
//				return;
//			
//			}
			
			
			request.getRequestDispatcher("board_write.jsp").forward(request, response);

		} else if (command.equals("/board/registForm.board")) {
			// 패키지 생성함
			// 서비스 만들러
			service = new BoardServiceImpl();
			service.regist(request, response);

		} else if (command.equals("/board/getContent.board")) {
			// 글 상세 내용화면 불러오기
			// 24)
			service = new BoardServiceImpl();
			service.getContent(request, response);

		} else if (command.equals("/board/modify.board")) {
			// 27)수정화면

			service = new BoardServiceImpl();
			service.modify(request, response);

		} else if (command.equals("/board/updateForm.board")) {
			// 32)액션에서 와서 수정 요청 >서비스

			service = new BoardServiceImpl();
			service.update(request, response);
		} else if (command.equals("/board/delete.board")) {
			// 37)xml 디자인 > 후에 화면 띄우기
			
			service = new BoardServiceImpl();
			service.delete(request, response);
			
			

		}

	}

}
