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

//경로 나열
// 세션이 있어야 접근할 수 있게 한다- 로그인관련
@WebFilter({"/board/write.board", 
	"/board/registForm.board",
	"/user/mypage.user",
	"/user/modify.user",
	"/user/update.user",
	"/user/delete.user",
	"/user/deleteForm.user"
	})
public class AuthenticationFilter implements Filter {

	// ctrl T 로 부모자식을 볼 수 있다
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		// 07-03
		// 세션이 있는지 확인해서 > 세션이 있으면 통과, 세션이 없으면 로그인 페이지로
		//
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;

		// 세션은 리퀘스트에서 얻는다
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("user_id");
		
		if(id == null) {//로그인이 없음, 안될때
			//접근을 못하게
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다');");
			out.println("location.href='/*" + request.getContextPath() + "*/login.user';");//절대경로
			//out.println("location.href='login.user';");//절대경로
			out.println("</script>");
			
			
			return; // 함수종료 필요
			
			
		}
		chain.doFilter(request, response);
		
		
	}

}
