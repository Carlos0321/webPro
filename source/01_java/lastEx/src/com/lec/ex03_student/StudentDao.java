package com.lec.ex03_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

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

	// 0. 첫 화면에 전공이름들 콤보박스에 추가 (mName)
	public Vector<String> getMNamelist() {
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return mnames;
	}

	// 1. 학번 검색 (sNo, sName, mName, score)
	public StudentDto sNogetStudent(int sNo) {
		StudentDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM MAJOR M , STUDENT S" + "    WHERE M.MNO = S.MNO AND SNO =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dto = new StudentDto(sNo, sName, mName, score);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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
	}// 2.이름 조회

	public ArrayList<StudentDto> sNamegetStudent(String sName) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM MAJOR M , STUDENT S"
				+ "    WHERE M.MNO = S.MNO AND SNAME =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int sNo = rs.getInt("sNo");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(sNo, sName, mName, score));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 3. 전공 검색
	public ArrayList<StudentDto> mNametudent(String mName) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK , SNAME||'('||SNO||')' sname, MNAME||'('||M.MNO||')' mname, SCORE"
				+ "    FROM MAJOR M, STUDENT S" + "    WHERE M.MNO = S.MNO AND MNAME = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
			//	String mName =rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank,sName,mName,score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 4. 학생입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),?,"
				+ "(SELECT MNO FROM MAJOR WHERE MNAME=?),?,1)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsName());
			pstmt.setString(2, dto.getmName());
			pstmt.setInt(3, dto.getScore());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 5. 학생수정
	public int updateStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SNAME=? , MNO= (SELECT MNO FROM MAJOR WHERE MNAME = ?),"
				+ "    SCORE = 100  WHERE SNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsName());
			pstmt.setString(2, dto.getmName());
			pstmt.setInt(3, dto.getsNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 6. 학생출력
	public ArrayList<StudentDto> getStudents() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' RANK  ,  A.* "
				+ "    FROM (SELECT SNAME||'('||SNO||')' 이름, MNAME||'('||M.MNO||')'학과명,SCORE 점수"
				+ "    FROM MAJOR M, STUDENT S" + "    WHERE M.MNO = S.MNO AND SEXPEL = 1"
				+ "    ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 7. 제적자출력
	public ArrayList<StudentDto> getStudentExpel() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' RANK  ,  A.* "
				+ "    FROM (SELECT SNAME||'('||SNO||')' 이름, MNAME||'('||M.MNO||')'학과명,SCORE 점수"
				+ "    FROM MAJOR M, STUDENT S" + "    WHERE M.MNO = S.MNO AND SEXPEL = 0"
				+ "    ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 8. 제적처리
	public int sNoExpel(int sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT  SET SEXPEL =0 WHERE SNO =? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}
}
