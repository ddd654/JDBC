package com.myweb.board.service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface BoardService {
	//
	void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	//
	void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	// 글 상세 내용
	void getContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	// 28) 수정화면 > 컨트롤러
	void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	// 33) 컨트롤러 > 글수정 기능 메서드
	void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	// 37) 컨트롤러 > 글삭제 기능 만들기 >오버라이딩
	void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
