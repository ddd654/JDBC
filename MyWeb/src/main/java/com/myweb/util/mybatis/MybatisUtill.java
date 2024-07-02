package com.myweb.util.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtill {

	// mybatis 세션 팩토리 객체 만들기, 설정파일의 위치 등을 지정한다

	private static SqlSessionFactory sqlSessionFactory;

	// 첫번째 실행시 1번만 동작된다.
	static {
		// src/main/resources 폴더 생성
		// src/main/resources/mybatis.config 패키지 생성
		// 밑에 mybatis-config.xml파일이 있어야합니다.

		try { //마이바티스 홈에 있던 내용들
			  
			String resource = "mybatis/config/mybatis-config.xml"; 
			// 5) resources 폴더 아래에서 경로가 시작함

			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			System.out.println("잘실행됨:" + sqlSessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("터졌냐?");
		}
	}

	// GETTER
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
