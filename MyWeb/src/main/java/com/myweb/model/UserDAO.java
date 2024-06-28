package com.myweb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.model.UserDAO;
import com.myweb.util.jdbcUtil;

import jakarta.servlet.jsp.jstl.sql.Result;

public class UserDAO {
	// 테이블 별로 하나씩 만든다?
	// DAO는 여러개 만들필요가 없어, 객체가 하나만 생성되도록 singleton방식으로 설계한다

	// 1. 나자신의 객체를 1개 생성 후 private 을 붙임
	private static UserDAO instance = new UserDAO();

	// 2. 직접 객체를 생성할 수 없도록 생성자에 private을 붙임
	UserDAO() {

		try {
			// 커넥션 풀에 사용할 객체를 얻어옴
			InitialContext init = new InitialContext(); // 시작설정 객체

			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle"); // context.xml 파일에서 name에 해당하는 값을 넣는다

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("에러났을때");
		}

		// 복사했으니
		// 커넥셔 풀 정보 수정해줘야한다
		// 서버에서 context.xml 유저랑 비번 JSP로 바꿈

	}

	// 3. 객체 생성을 요구할때 getter 메서드를 사용해서 1번의 객체를 반환한다
	public static UserDAO getInstance() { // static 같은 곳에서 사용
		return instance;
	}

	// ---------------

//		 데이터베이스 연결하기, 멤버 변수로 옮김
//		public String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		public String uid = "HR";
//		public String upw = "HR";
	//

	// 커넥션 풀 객체정보
	private DataSource ds;

	// 이제 필요한 메서드를 생성한다
	// VO는 값을 옮겨주는 클래스이다 = DTO

	// 아이디 중복 검사하는 메서드
	public int findUser(String id) {
		int result = 0;

		String sql = "SELECT * FROM USERS WHERE ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {// 다음행이 있다면 유저가 있다는 의미
				result = 1; // 유저가 있다는 뜻

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 닫는 작업 메서드
			jdbcUtil.close(conn, pstmt, rs);

		}

		return result;
	}

	// 회원가입하는 메서드
	public void insertUser(String id, String pw, String name, String email, String gender) {

		String sql = "INSERT INTO USERS(ID, PW, NAME, EMAIL, GENDER) VALUES (?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, gender);

			pstmt.executeUpdate(); // i, u, d 구문은 executeUpdate()

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt, null);

		}

	}

	// 무슨 메서드
	public UserDTO login(String id, String pw) {

		String sql = "SELECT * FROM USERS WHERE ID = ? AND PW = ?";

		UserDTO dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String email = rs.getString("email");

				dto = new UserDTO(id, null, name, email, gender, null);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			jdbcUtil.close(conn, pstmt, null);
		}

		return dto;
	}

	//
	// 아이디를 기반으로 회원정보를 조회하는 getInfo() 메서드 만들기
	public UserDTO getInfo(String id) { // void?

		String sql = "SELECT * FROM USERS WHERE ID = ?";

		UserDTO dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 다음행이 있으면
				String id1 = rs.getString("ID");
				String name=rs.getString("name");
				String email=rs.getString("email");

				String gender=rs.getString("gender");
				
				dto = new UserDTO(id1, null, name, email, gender, null);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt, rs);
		}

		return dto;
	}

}
