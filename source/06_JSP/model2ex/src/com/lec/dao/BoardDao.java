package com.lec.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.lec.dto.BoardDto;
public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {}
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
	// (1) 글목록(startRow부터 endRow까지) - 글번호, 작성자이름, ...
	public ArrayList<BoardDto> listBoard(int startRow, int endRow){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM " + 
			" (SELECT ROWNUM RN, A.* FROM " + 
			" (SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M "+ 
					" WHERE F.MID=M.MID ORDER BY FGROUP DESC, FSTEP) A)" + 
			" WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fId      = rs.getInt("fId");
				String mId   = rs.getString("mId");
				String mName = rs.getString("mName"); // join해서 출력
				String fTitle= rs.getString("fTitle");
				String fContent= rs.getString("fContent");
				String fFileName= rs.getString("fFileName");
				Date   fRdate   = rs.getDate("fRDate");
				int    fHit    = rs.getInt("fHit");
				int    fGroup  = rs.getInt("fGroup");
				int    fStep   = rs.getInt("fStep");
				int    fIndent = rs.getInt("fIndent");
				String fIp     = rs.getString("fIp");
				dtos.add(new BoardDto(fId, mId, mName, fTitle, fContent, 
						fFileName, fRdate, fHit, fGroup, fStep, fIndent, fIp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
	// (2) 글갯수
	public int getBoardTotCnt() {
		int cnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return cnt;
	}
	// (3) 글쓰기(원글)
	public int writeBoard(String mId, String fTitle, String fContent, String fFileName,
			String fIp) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD "
			+ " (FID, MID, FTITLE, FCONTENT, FFILENAME, "
			+ " 	FGROUP, FSTEP, FINDENT, FIP) "
			+ " VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ? , ?, "
			+ "		FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, fTitle);
			pstmt.setString(3, fContent);
			pstmt.setString(4, fFileName);
			pstmt.setString(5, fIp);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "원글쓰기성공":"원글쓰기실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// (4) FHit 하나 올리기(1번글 조회수 하나 올리기)
	private void hitUp(int fId) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
	}
	// (5) bId로 글 dto보기 : 글 상세보기(조회수 up + bid로 dto리턴)
	public BoardDto contentView(int fId) {
		hitUp(fId);
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M "
				+ "WHERE M.MID=F.MID AND FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mId   = rs.getString("mId");
				String mName = rs.getString("mName"); // join해서 출력
				String fTitle= rs.getString("fTitle");
				String fContent= rs.getString("fContent");
				String fFileName= rs.getString("fFileName");
				Date   fRdate   = rs.getDate("fRdate");
				int    fHit    = rs.getInt("fHit");
				int    fGroup  = rs.getInt("fGroup");
				int    fStep   = rs.getInt("fStep");
				int    fIndent = rs.getInt("fIndent");
				String fIp     = rs.getString("fIp");
				dto = new BoardDto(fId, mId, mName, fTitle, fContent, fFileName, 
						fRdate, fHit, fGroup, fStep, fIndent, fIp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return dto;
	}
	// (5) bId로 글 dto보기 : 답변글 view + 수정 view (bid로 dto리턴)
	public BoardDto modifyView_replyView(int fId) {
		hitUp(fId);
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M "
				+ "WHERE M.MID=F.MID AND FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mId   = rs.getString("mId");
				String mName = rs.getString("mName"); // join해서 출력
				String fTitle= rs.getString("fTitle");
				String fContent= rs.getString("fContent");
				String fFileName= rs.getString("fFileName");
				Date   fRdate   = rs.getDate("fRdate");
				int    fHit    = rs.getInt("fHit");
				int    fGroup  = rs.getInt("fGroup");
				int    fStep   = rs.getInt("fStep");
				int    fIndent = rs.getInt("fIndent");
				String fIp     = rs.getString("fIp");
				dto = new BoardDto(fId, mId, mName, fTitle, fContent, fFileName, 
						fRdate, fHit, fGroup, fStep, fIndent, fIp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return dto;
	}
	// (6) 글 수정하기(FId, FTitle, FContent, FILENAME,  FIp, FDATE)
	public int modifyBoard(int fId, String fTitle, String fContent, String fFileName, 
			String fIp) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FTITLE = ?, " + 
				"                    FCONTENT = ?, " + 
				"                    FFILENAME = ?, " + 
				"                    FIP = ?, " + 
				"                    FRDATE = SYSDATE " + 
				"            WHERE FID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fTitle);
			pstmt.setString(2, fContent);
			pstmt.setString(3, fFileName);
			pstmt.setString(4, fIp);
			pstmt.setInt(5, fId);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글수정성공":"글수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// (7) 글 삭제하기(bId로 삭제하기)
	public int deleteBoard(int fId) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글삭제성공":"글삭제실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// (8) 답변글 추가전 STEP a 수행
	private void preReplyStepA(int fGroup, int fStep) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP+1  " + 
				"    WHERE FGROUP = ? AND FSTEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fGroup);
			pstmt.setInt(2, fStep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
	}
	// (9) 답변글 쓰기
	public int replyBoard(String mId, String fTitle, String fContent,
			String fFileName, String fIp,
			int fGroup, int fStep, int fIndent) {
		preReplyStepA(fGroup, fStep); // 답변글 저장전 step A 먼저 실행
		// bgroup, bstep, bindent 원글정보
		// bname, btitle, bcontent, bip 답변글 정보
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD "
		 + "(FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP) "
		 + " VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, fTitle);
			pstmt.setString(3, fContent);
			pstmt.setString(4, fFileName);
			pstmt.setInt(5, fGroup);
			pstmt.setInt(6, fStep+1);
			pstmt.setInt(7, fIndent+1);
			pstmt.setString(8, fIp);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "답변쓰기성공":"답변쓰기실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// (10) 회원탈퇴 하려는 사람이 쓴 글 모두 삭제 후 탈퇴
	public void withdrawalDeleteBoard(String mId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE MID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}