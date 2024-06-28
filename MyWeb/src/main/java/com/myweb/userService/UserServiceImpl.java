package com.myweb.userService;

import java.io.IOException;
import java.io.PrintWriter;

import com.myweb.model.UserDAO;
import com.myweb.model.UserDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

public class UserServiceImpl implements UserService{
	
	//마우스로 만들기
	@Override
	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		//이 값들을 인설트한다
		
		//그런데, 중복되는 회원이 있는지 확인해서
		// 중복이 없을때 회원가입 처리한다
		
		
		UserDAO dao = UserDAO.getInstance();
		int cnt = dao.findUser(id);
		
		if(cnt ==1) { //1은 아이디가 중복이다
			
//			response.setContentType("text/html; charset-utf-8");// 응답문서에 대한 컨텐츠ㅡ타입
			
			request.setAttribute("msg", "이미 존재하는 회원입니다");
			request.getRequestDispatcher("join.jsp").forward(request, response);
			//서블릿이 동작하여 나가고 msg가 페이지로 가게된다
			
			
			PrintWriter out = response.getWriter();
			
		}else { //중복이 아니면 회원가입을 시킨다
			dao.insertUser(id, pw, name, email, gender);
			
//			response.sendRedirect("login.jsp");
			
			response.sendRedirect("login.user");// 다시 컨트롤러로
			//MVC방식에서 리다이렉트는 다시 컨트롤러를 태울때 사용한다
			
		}
		
	}

	//유저 서비스에서 만들고 온것
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//로그인 시도
		UserDAO dao = UserDAO.getInstance();
		UserDTO dto = dao.login(id, pw);
		
		if(dto == null) {
			
			//아이디나 비밀번호가 틀림
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			
			//그대로 로그인 페이지
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			
		} else { //로그인 성공했을때
			//세션에 로그인 성공에 대한 내용을 저장
			HttpSession session =request.getSession(); // 리퀘스트에서 현재 세션을 얻음
			
			//세션에 값 기록하기
			session.setAttribute("user_id", dto.getId());
			session.setAttribute("user_name", dto.getName());
			//이제 메인화면으로 이동
			
			response.sendRedirect("mypage.user"); // 다시 컨트롤러로 간다
			
		}
		
	}

	
	
	@Override
	public void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 기반으로 회원정보를 조회해서 데이터를 가져와서 수정페이지로 이동한다
		
		//해보기
		//1. 아이디는 세션에 있습니다 -
		//2. 아이디 기반으로 회원정보를 조회하는 getInfo() DAO에 생성합니다 -
		//3. 서비스에서는 getInfo()를 호출하고, 조회한 데이터를 request에 저장합니다 
		//4. forward를 이용해서 modify.jsp로 이동한다
		//5. 회원정보를 input태그에 미리 출력해주면 됩니다
		
		//
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//
		UserDAO dao = UserDAO.getInstance();
		UserDTO userInfo = dao.getInfo(userId);
		
		if(userInfo == null) {
			request.setAttribute("msg", "번호를 확인하세요");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			//세션에 값 저장
			request.setAttribute("userInfo", userInfo);
			
			response.sendRedirect("mypage.user"); // 다시 컨트롤러로 간다

			
//			request.getRequestDispatcher("modify.jsp").forward(request, response);

		}
		
		
		
	}
	
	
	

}
