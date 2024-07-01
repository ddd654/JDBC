package com.myweb.userService;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;

import com.myweb.model.UserDAO;
import com.myweb.model.UserDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

public class UserServiceImpl implements UserService {

	// 마우스로 만들기
	@Override
	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		// 이 값들을 인설트한다

		// 그런데, 중복되는 회원이 있는지 확인해서
		// 중복이 없을때 회원가입 처리한다

		UserDAO dao = UserDAO.getInstance();
		int cnt = dao.findUser(id);

		if (cnt == 1) { // 1은 아이디가 중복이다

//			response.setContentType("text/html; charset-utf-8");// 응답문서에 대한 컨텐츠ㅡ타입

			request.setAttribute("msg", "이미 존재하는 회원입니다");
			request.getRequestDispatcher("join.jsp").forward(request, response);
			// 서블릿이 동작하여 나가고 msg가 페이지로 가게된다

			PrintWriter out = response.getWriter();

		} else { // 중복이 아니면 회원가입을 시킨다
			dao.insertUser(id, pw, name, email, gender);

//			response.sendRedirect("login.jsp");

			response.sendRedirect("login.user");// 다시 컨트롤러로
			// MVC방식에서 리다이렉트는 다시 컨트롤러를 태울때 사용한다

		}

	}

	// 유저 서비스에서 만들고 온것
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		// 로그인 시도
		UserDAO dao = UserDAO.getInstance();
		UserDTO dto = dao.login(id, pw);

		if (dto == null) {

			// 아이디나 비밀번호가 틀림
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");

			// 그대로 로그인 페이지
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else { // 로그인 성공했을때
			// 세션에 로그인 성공에 대한 내용을 저장
			HttpSession session = request.getSession(); // 리퀘스트에서 현재 세션을 얻음

			// 세션에 값 기록하기
			session.setAttribute("user_id", dto.getId());
			session.setAttribute("user_name", dto.getName());
			// 이제 메인화면으로 이동

			response.sendRedirect("mypage.user"); // 다시 컨트롤러로 간다

		}

	}

	@Override
	public void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 기반으로 회원정보를 조회해서 데이터를 가져와서 수정페이지로 이동한다

		// 해보기
		// 1. 아이디는 세션에 있습니다 -
		// 2. 아이디 기반으로 회원정보를 조회하는 getInfo() DAO에 생성합니다 -
		// 3. 서비스에서는 getInfo()를 호출하고, 조회한 데이터를 request에 저장합니다
		// 4. forward를 이용해서 modify.jsp로 이동한다
		// 5. 회원정보를 input태그에 미리 출력해주면 됩니다

		//
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
//		String id =session.getAttribute("user_Id");

		// DAO 객체 생성 new가아닌
		// 세션 id 값을 메개변수로 넣고, getInfo 메서드를 호출
		UserDAO dao = UserDAO.getInstance();
		UserDTO dto = dao.getInfo(id); // dto로 받는다

		// dto를 이제 클라이언트로 갖고가야한다, 화면으로
		request.setAttribute("dto", dto);// "이름" , 값
		request.getRequestDispatcher("modify.jsp").forward(request, response);
		// 이동해야될 경로, 포워드

		// 1.
		// 웹에서 회원정보관리로 들어가는데, 컨트롤러를 타고서 데이터를 갖고 다시 화면으로 이동하게된다
		// sql의 물음표값으로 시작
		// DAO로
	}

	// Userservice 에서
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리퀘스트 객체를 갖고 클라이언트의 값을 받는다
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		// 위 값을들 DAO에 넘겨서 업데이트 작업을 한다
		// DAO에 업데이트관련 메서드를 만들어야 한다

		// parameter를 dto에 저장한다
		UserDTO dto = new UserDTO(id, pw, name, email, gender, null);
		// dto는 값을 전달해주는 역할이여서 위처럼 썼다

		// DAO생설하고 실행하겠다, 업뎃 메서드는 정수형으로 반환
		UserDAO dao = UserDAO.getInstance();
		int result = dao.update(dto);

		//
		// 조건나누기
		if (result == 1) { // 성공
			// 세션에 name을 수정
			HttpSession session = request.getSession();
			session.setAttribute("user_name", name); // 위 name을 안으로

			// 자바에서 알림창을 화면에 보내기
			// out 객체 - 클라이언트로 출력을 한다는 뜻
			response.setContentType("text/html; charset=UTF-8");// 문서에 대한 타입

			// 브라우저의 출력 타입
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보가 정상 수정되었습니다');");
			// 경고창이 나오면 화면 이동을 시킨다

			out.println("location.href='mypage.user';");
			out.println("</script>");

//			<script>
//			alert("경고창");
//			location.href = '이동경로';
//			</script>

		} else {
			// 실패면 유저페이지로 보내보자
			// MVC2에서 리다이레그는 컨트롤러의 경로이다
			// = 컨트롤러의 mypage.user로 보내서 화면으로 나간다, 바꿀수 있음
			response.sendRedirect("mypage.user");
		}

	}

	// UserServiceImpl 단어 호버해서 오버라이드
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 화면에서 넘어오는 pw값을 받으세요 - 세션에서
		// 2. 회원탈퇴는 비밀번호가 일치하는지 확인하고, 탈퇴한다
		// > login메서드로 id, pw를 받아서 비밀번호가 일치하는지 확인할 수 있다
		// 3. login 메서드가 DTO을 반환하면 DAO에 delete 메서드를 만들고
		// 회원 삭제를 진행하면 된다
		// 4. 탈퇴 성공시에는 세션을 전부 삭제하고, "홈화면" 으로 리다이렉트 한다.
		// > login메서드가 null을 반환하여 비밀번호가 틀린경우에는 delete.jsp에 "비밀번호를 확인하세요" 메시지를 남겨주면 됩니다.

		//
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String pw = request.getParameter("pw");
		// String pw = (String) session.getAttribute("pw");

		// pw가 일치하는지 login메서드로 확인
		UserDAO dao = UserDAO.getInstance();
		UserDTO dto = dao.login(id, pw);

		if (dto != null) { // pw가 일치하면
			// delete 실행하는 곳
			dao.delete1(id);

			// 세션 지우기
			session.invalidate();

			// 페이지 홈으로, 홈화면
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		} else {
			// 비밀번호 다른경우
			request.setAttribute("msg", "탈퇴시 비밀번호를 확인하세요");

			// 페이지 그대로
			request.getRequestDispatcher("delete.jsp").forward(request, response);

		}

	}

	// 회원가입 만들기 정리

	// 가입 > 중복검사, 데이터 insert
	// 로그인 > select
	// 회원정보 확인 > select
	// 수정 >update
	// 탈퇴 >delete

}
