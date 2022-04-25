package com.lec.ex03_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static StudentDao INSTANCE;
	public static int SUCCESS = 1;
	public static int FAIL = 0;

	public static StudentDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}

	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1. 학번 검색 (sNo, sName, mName, score)
	public StudentDto sNogetStudent(int sNo) {
		StudentDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM MAJOR M , STUDENT S" + 
				"    WHERE M.MNO = S.MNO AND SNO =?";
		try {
			conn= DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dto = new StudentDto(sNo,sName, mName, score);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			}
			return dto;
	}//2.이름 조회
		public ArrayList<StudentDto> selectName(String sName){
			ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet			rs = null;
			String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM MAJOR M , STUDENT S" + 
					"    WHERE M.MNO = S.MNO AND SNAME =?";
			try {
				conn= DriverManager.getConnection(url, "scott", "tiger");
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1, sName);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return dtos;
		}
}
