package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	// 싱글톤
	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	private BoardDao() {
	}

	// Connection 객체를 받아오는 getConnection()
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 1. 글 갯수 :
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM BOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt(1); // 1열의 데이터를 int값으로 받아옴
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

			}
		}

		return totalCnt;
	}

	// 2. 글 목록 :
	public ArrayList<BoardDto> listBoard() {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD ORDER BY REF DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				dtos.add(new BoardDto(num, writer, subject, content, email, readcount, pw, ref, re_step, re_indent, ip,
						rdate));
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

			}
		}
		return dtos;
	}

	// 2-1 글목록 top-N 적용
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + "    FROM(SELECT  ROWNUM RN, A.*"
				+ "       FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A)" + "       WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				dtos.add(new BoardDto(num, writer, subject, content, email, readcount, pw, ref, re_step, re_indent, ip,
						rdate));
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

			}
		}
		return dtos;
	}

	// 3. 원글쓰기:
	public int insertBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)"
				+ "    VALUES( (SELECT NVL (MAX(NUM),0)+1 FROM BOARD),?,?,?,?,"
				+ "    ?,(SELECT NVL (MAX(NUM),0)+1 FROM BOARD),0,0,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
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

			}
		}
		return result;
	}

	// 4. 글번호로 글 한줄 가져오기 :
	public BoardDto getBoardOneLine(int num) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				dto = new BoardDto(num, writer, subject, content, email, readcount, pw, ref, re_step, re_indent, ip,
						rdate);
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

			}
		}
		return dto;
	}

	// 4. 글번호로 글 한줄 가져오기 :
	public BoardDto getBoardOneLine(String num) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				dto = new BoardDto(Integer.parseInt(num), writer, subject, content, email, readcount, pw, ref, re_step,
						re_indent, ip, rdate);
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

			}
		}
		return dto;
	}

	// 5. 조회수 올리기 :
	public void readcountUp(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET READCOUNT  = READCOUNT +1 WHERE NUM =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
		}
	}

	// 5. 조회수 올리기 :
	public void readcountUp(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET READCOUNT  = READCOUNT +1 WHERE NUM =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
		}
	}

	// 6. 글 수정 :
	public int updateBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET SUBJECT = ?, " + "                            CONTENT = ?,"
				+ "                            EMAIL=?,  " + "                            PW=?,"
				+ "                            IP= ? " + "                            WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPw());
			pstmt.setString(5, dto.getIp());
			pstmt.setInt(6, dto.getNum());
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

			}
		}
		return result;
	}

	// 7. 글 삭제 :
	public int deleteBoard(int num, String pw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE NUM=? AND PW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
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

			}
		}
		return result;
	}

	// 8. 답변글 저장전 STEP ⓐ
	private void preReplyStepA(int ref, int re_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE BOARD SET RE_STEP = RE_STEP + 1 WHERE REF=? AND RE_STEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(1, re_step);
			int result = pstmt.executeUpdate();
			System.out.println(result + "개 조정");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}//try
		}//finally
	}//preReplystep
	
	// 9. 답변글 저장
	public int reply(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//num, writer, subject, content, email, pw, ref, re_step, re_indent, ip
		//사용자로부터 입력받을 답변글 내용 : writer, subject, content, email, pw
		//원글에 대한 정보 : ref, re_step,re_indent
		//시스템으로부터 구현되어 저장될 정보 : ip
		String sql = " INSERT INTO BOARD (NUM,WRITER,SUBJECT,CONTENT,EMAIL,PW,REF,RE_STEP,RE_INDENT,IP)" + 
				"    VALUES((SELECT NVL (MAX(NUM),0)+1 FROM BOARD),?,?,?,?,?,?,?,?,?)";
		preReplyStepA(dto.getRef(), dto.getRe_step()); //답변글 저장 전 step A
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setInt(6, dto.getRef());
			pstmt.setInt(7, dto.getRe_step()+1); //원글의 re_step+1
			pstmt.setInt(8, dto.getRe_indent()+1); //원글의 re_indent+1
			pstmt.setString(9, dto.getIp()); 
			result= pstmt.executeUpdate();
			//DB에 저장될 dto 내용 
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_indent(dto.getRe_indent()+1);
			System.out.println(result ==SUCCESS ? "답변글 성공" + dto :"답변글 실패" +dto) ;
		}catch (Exception e) {
			System.out.println(e.getMessage() + "답변글 실패" +dto);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}//try
		}//finally
		return result;
	}
}
