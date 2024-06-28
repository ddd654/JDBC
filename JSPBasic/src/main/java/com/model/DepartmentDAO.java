package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DepartmentDAO {

	// 테이블 별로 하나씩 만든다?
	// DAO는 여러개 만들필요가 없어, 객체가 하나만 생성되도록 singleton방식으로 설계한다

	// 1. 나자신의 객체를 1개 생성 후 private 을 붙임
	private static DepartmentDAO instance = new DepartmentDAO();

	// 2. 직접 객체를 생성할 수 없도록 생성자에 private을 붙임
	DepartmentDAO() {

		try {
			// 커넥션 풀에 사용할 객체를 얻어옴
			InitialContext init = new InitialContext(); // 시작설정 객체

			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle"); // context.xml 파일에서 name에 해당하는 값을 넣는다

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("에러났을때");
		}

	}

	// 3. 객체 생성을 요구할때 getter 메서드를 사용해서 1번의 객체를 반환한다
	public static DepartmentDAO getInstance() { // static 같은 곳에서 사용
		return instance;
	}

	// ---------------

//	 데이터베이스 연결하기, 멤버 변수로 옮김
//	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	public String uid = "HR";
//	public String upw = "HR";
	//

	// 커넥션 풀 객체정보
	private DataSource ds;

	// 이제 필요한 메서드를 생성한다
	// VO는 값을 옮겨주는 클래스이다 = DTO

	// DTO는 한 행을 저장한다
	// ojdbc는 데이터 연결해주는 거
	// 부서명 조회하는 메서드 만들기 <<
	public ArrayList<DepartmentDTO> getList() {// 반환 유형을 리스트 유형으로 한다

		ArrayList<DepartmentDTO> list = new ArrayList<>();

		String sql = "SELECT * FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL";

		Connection conn = null; // 연결객체
		PreparedStatement pstmt = null; // sql문 실행 객체, 지역 변수들
		ResultSet rs = null; // 결과처리 객체

		try {
//			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 호출

//			conn = DriverManager.getConnection(url, uid, upw); // conn 객체

			conn = ds.getConnection();// tomcat이 만들어준 풀을 사용해준다

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(); // select 구문 실행하기

			while (rs.next()) { // 다음 행이 있으면 true

				// 1행에 대한 처리하기
				int departmentId = rs.getInt("department_id"); // (칼럼명)
				String departmentName = rs.getString("department_name");
				int managerId = rs.getInt("manager_id");
				int locationId = rs.getInt("location_id");

				// 1행은 DTO에 담고 리스트에 넣는다
				DepartmentDTO dto = new DepartmentDTO(departmentId, departmentName, managerId, locationId);

				// 리스트에 추가하기, 추가
				list.add(dto); // 이제 반복되면서 여러행이 조회된다

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 에러로그 확인하기
		} finally {

			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		return list;

	}

}