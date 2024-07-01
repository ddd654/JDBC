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

@WebServlet("*.board") // .board로 끝나는 모든 요청은 서블렛으로 받기
public class BoardController extends HttpServlet {

	public BoardController() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);

	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//요청을 분기

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

			request.getRequestDispatcher("board_write.jsp").forward(request, response);

		} /* d */ else if (command.equals("/board/registForm.board")) {
			// 패키지 생성함
			// 서비스 만들러
			service = new BoardServiceImpl();
			service.regist(request, response);

		}

	}

}
