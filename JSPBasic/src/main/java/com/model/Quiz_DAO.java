package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Quiz_DAO {

	private static Quiz_DAO instance = new Quiz_DAO();
	private DataSource ds;

	Quiz_DAO() {

		try {
			InitialContext init = new InitialContext();

			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error");
		}

	}

	public static Quiz_DAO getInstance() {
		return instance;
	}

	//

	// 리스트로
	public ArrayList<Quiz_DTO> getList(int department_id) {

		ArrayList<Quiz_DTO> list = new ArrayList<Quiz_DTO>();

		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, department_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int departmentId = rs.getInt("department_id");
				String departmentName = rs.getString("department_name");
				int managerId = rs.getInt("manager_id");
				int locationId = rs.getInt("location_Id");

				Quiz_DTO dto = new Quiz_DTO(departmentId, departmentName, managerId, locationId);

				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return list;
	}

//	//부서번호를 조회하는 메서드, 리스트가 아닌 하나의 행을 처리하는 메서드
//		public DepartmentDTO getDept(String dno) {
//			DepartmentDTO dto = null;
//			Connection conn = null;
	
//			rs
//			
//			String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";
//			
//			try {
//				conn = ds.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, dno);
//				
//				
//				//한바퀴만 돌기에 while 안써도 된다
//				
//				while(rs.next()) {
//					dto = new DepartmentDTO();
//					
//					int departmentId = rs.getInt("department_id");
//					String departmentName = rs.getString("department_name");
//					int managerId = rs.getInt("manager_id");
//					int locationId = rs.getInt("location_Id");
//					
//				}
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//			닫아주는 작업
//			
//			return dto;
//		}

}
