package com.myweb.board.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardDTO;
import com.myweb.board.model.BoardMapper;
import com.myweb.util.mybatis.MybatisUtill;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardServiceImpl implements BoardService {

	// 7) 멤버 변수에 세션팩토리 선언
	// 앞글자만 소문자로 쓰기
	private SqlSessionFactory sqlSessionFactory = MybatisUtill.getSqlSessionFactory();

	// 글 작성하고 등록하는 기능
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

//		// 18. dao 객체 추가하기
//
//		BoardDAO dao = BoardDAO.getInstance();
//		dao.regist(writer, title, content);
//
//		// 19. 글 작성 후에는 목록 화면으로 이동한다 - 포워드로 이동하면 안됨
//		request.getRequestDispatcher("board_list.jsp").forward(request, response);
//		// >> 컨트롤러로 가서 마저 수정
//		
//		// 32. 목록화면이 바로 안보여서 리다이렉트로
//		// 글작성 후에도 바로 목록이 보이게 된다
//		response.sendRedirect("list.board");

		// -----------------------
		// 15) 호출
		BoardDTO dto = new BoardDTO(0, writer, title, content, null, 0);

		// 실행마다 커밋이 반영된다
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardMapper board = sql.getMapper(BoardMapper.class);
		int result = board.regist(dto);
		sql.close();

		System.out.println("성공실패여부:" + result);

		// 16) 목록화면을 리다이렉트로 내보낸다
		response.encodeRedirectURL("list.board");

	}

	// 22. 서비스 정리 겟리스트 만들기
	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		// 27. DAO 생성하고 겟리스트 목록 호출하기
//		BoardDAO dao = BoardDAO.getInstance();
//		ArrayList<BoardDTO> list = dao.getList();
//
//		// 28. 이제 화면 들고 나가야되니 포워드로 뚫어 보낸다
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("board_list.jsp").forward(request, response);
//		// board_list를 만나면 포워드로 보내라
//		// 29. 보드 리스트로 가서 수정하기

		//
		// -------
		// 6) BoardMapper에서 와서 DAO를 대신하는 마이바티스 사용하기
		// 여기서 호출하기 마이바티스에도 호출방법 나와있음

		// 8) 호출하기
		SqlSession sql = sqlSessionFactory.openSession();

//		Class<?> x =BoardMapper.class;
		BoardMapper board = sql.getMapper(BoardMapper.class); // 클래스 정보를 넣는다, 호출시킬 인터페이스 명 작성

//		//8)
//		String now = board.now();
//		System.out.println("sql문 실행됨:" + now); 
//		//지금은 board에 진입하자마자 실행된다
//		//마이바티스가 DAO대신이 된것이다 

		// 11) 리스트들 화면에 내보내기
		ArrayList<BoardDTO> list = board.getList();
		System.out.println(list);

		// request저장하고 포워드
		request.setAttribute("list", list);
		request.getRequestDispatcher("board_list.jsp").forward(request, response);

	}

	// 18) 서비스에서 메서드 하나 만들고
	// 19) 여기 인터페이스에서 오버라이딩
	@Override
	public void getContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// a 링크로 넘어온 bno값을 받음
		// db로 넘겨서 데이터 조회해야한다
		String bno = request.getParameter("bno");

		//
		// 22) 마이바티스 실행
		SqlSession sql = sqlSessionFactory.openSession();
		BoardMapper mapper = sql.getMapper(BoardMapper.class);

		mapper.increaseHit(bno);
		BoardDTO dto = mapper.getContent(bno);// 결과가 나갔다가 돌아옴, 반환 받기
		sql.close();

		// 23) request에 담고 포워드로 보냄
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("board_content.jsp").forward(request, response);

	}

	// 29) 인터페이스명 호버 > 오버라이드
	@Override
	public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// a 링크로 넘어온 bno값을 받음
		// db로 넘겨서 데이터 조회해야한다
		String bno = request.getParameter("bno");

		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardMapper mapper = sql.getMapper(BoardMapper.class);
		BoardDTO dto = mapper.getContent(bno);

		// 바이바티스 세션 close 하기
		sql.close();

		request.setAttribute("dto", dto);
		request.getRequestDispatcher("board_modify.jsp").forward(request, response);

	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

//		//33) 확인용, bno 내보내기 위한 modify에서 히든 수정
//		System.out.println(bno);
//		System.out.println(title);
//		System.out.println(content);

		// 36)
		// BoardDTO dto = new BoardDTO(0, bno, title, content, null, 0);
		BoardDTO dto = new BoardDTO();
		dto.setBno(Integer.parseInt(bno));
		dto.setTitle(title);
		dto.setContent(content);

		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardMapper mapper = sql.getMapper(BoardMapper.class);

		int result = mapper.update(dto);
		sql.close(); // close

		// 성공실패 확인하기 alert
		if (result == 1) {
			// 업데이트 성공일때
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();

			out.print("<script>");
			out.print("alert('정상 처리 되었습니다');");
			out.print("location.href='list.board';");
			out.print("</script>");

		} else {
			// 실패했을때
			// content는 bno를 필요로 함
			response.sendRedirect("getContent.board?bno=" + bno);
			// 다시 수정화면으로 보냄
		}

	}

	// 38)오버라이딩
	// 41)
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 화면에서 전달되는 bno값을 얻음
		// 2. mapper에 <delete> 태그를 추가합니다
		// 사용방식은 insert, update와 같음
		// 3. 서비스 영역에서는 bno를 이용해서 삭제를 진행하고,
		// 삭제 후에는 목록페이지로 이동하세요

		// System.out.println(bno + " " + "사과");

//		BoardDTO dto = new BoardDTO();
//		dto.setBno(Integer.parseInt(bno));
		String bno = request.getParameter("bno");

		// sql
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardMapper mapper = sql.getMapper(BoardMapper.class);

		// 호출시킬 메서드
		mapper.delete(bno);
		sql.close();
		// void 형이면 여기까지가 끝이다

		// 화면이동
		response.sendRedirect("list.board");
	}

}
