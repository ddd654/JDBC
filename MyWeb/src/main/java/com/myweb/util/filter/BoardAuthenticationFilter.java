package com.myweb.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebFilter({"/board/modify.board",
	"/board/updateForm.board",
	"/board/delete.board"
	})
public class BoardAuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 게시글, 수정, 삭제에 대한 필터
		// 내가 쓴글은 나만 수정할 수 있다
		// 화면에서 세션값과 클라이언트에서 넘어오는 글쓴이(user_id)값을 서로 비교
		
		//수정, 삭제 요청이 들어올떄는 작성자(writer) 정보를 넘겨준다

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// 현재 로그인 되어있는 세션값
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");

		// 세션이 없는경우에 로그인 페이지로 보낸다
		if (id == null) {// 로그인이 없음, 안될때
			// 아이디가 널이면 접근을 못하게 한다
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다');");
			// out.println("location.href='/*" + request.getContextPath() +
			// "*/login.user';");//절대경로
			out.println("location.href='login.user';");// 절대경로
			out.println("</script>");

			return; // 함수종료 필요 > 컨트롤러를 실행하지 않게 한다
		}
		//클라이언트에서 넘어로는 id값과 세견id값을 비교한다
		
		String writer = request.getParameter("writer");
		//writer 들어가는 이유 -writer인 작성자가 세션과 같으면 통과 
		
		if(writer == null || writer.equals(id) == false) {//작성자가 널이거나, 세션값과 작성자가 같이 안다면
			//!writer.equals();
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다');");
			//절대경로 관련 문제
			out.println("location.href='/board/list.board';");
			out.println("</script>");
			
			return; 
		}
		
		chain.doFilter(request, response); //컨트롤러 실행됨
		
		//그다음 맨위에서 경로 지정
		
	}
}
