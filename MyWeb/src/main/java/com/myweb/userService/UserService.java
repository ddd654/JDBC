package com.myweb.userService;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
	
	//컨트롤러에서 가져와서 구현체 만들기
	void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	//인터페이스 하나 만들기
	void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	
	//메서드 하나 추가
	void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	//오버라이딩 하러






}
