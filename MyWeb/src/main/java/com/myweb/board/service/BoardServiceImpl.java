package com.myweb.board.service;

import java.io.IOException;
import java.util.ArrayList;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardServiceImpl implements BoardService {

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 13. 확인하기
		// System.out.println("ok");
		// 출력문 적고서 글작성하기 눌러서 확인하기 = 데이터가 갔나

		// 14. 사용자가 입력한 값을 받음- 작성자 글제목 글내용 3개

		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 15. DAO에 넣어주기

		// 18. dao 객체 추가하기

		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(writer, title, content);

		// 19. 글 작성 후에는 목록 화면으로 이동한다 - 포워드로 이동하면 안됨
		request.getRequestDispatcher("board_list.jsp").forward(request, response);
	
	
		//32. 목록화면이 바로 안보여서 리다이렉트
		response.sendRedirect("list.board");
	
	
	
	}

	//22. 서비스 정리 겟리스트 만들기
	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//27. DAO 생성하고 겟리스트 목록 호출하기
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> list =dao.getList();
		
		//28. 이제 화면 들고 나가야되니 포워드로 뚫어 보낸다
		request.setAttribute("list", list);
		request.getRequestDispatcher("board_list.jsp").forward(request, response);
		//board_list를 만나면 포워드로 보내라
		//29. 보드 리스트로 가서 수정하기
		
		
		
	}

}
