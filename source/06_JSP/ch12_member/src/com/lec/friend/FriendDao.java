package com.lec.friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FriendDao {
	public static final int SUCCESS =1;
	public static final int FAIL =0;
	
	private static FriendDao instance;
	public static FriendDao getInstance() {
		if(instance==null) {
			instance = new FriendDao();
		}
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		
		// 컨넥션풀의 DataSource안의 conn객체 이용
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("커넥션풀이름 오류 : " +e.getMessage());
		}
		return conn;
	}
	//친구 추가
	public int join (FriendDto dto) {
		int result = FAIL; //질문 1 
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND(N, FNAME,TEL) VALUES(FRIEND_SEQ.NEXTVAL,?,?)";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFname());
			pstmt.setString(2, dto.getTel());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "친구추가 성공": "친구추가 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("친구추가 실패 : "+dto);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
			}
		}
		return result;
	}
	//모든 친구 출력
	public ArrayList<FriendDto> getFriend() {
		ArrayList<FriendDto> dto = new ArrayList<FriendDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND";
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int n = rs.getInt("n");
				String fname = rs.getString("fname");
				String tel = rs.getString("tel");
				dto.add(new FriendDto(n,fname,tel));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
	//친구찾기 
	public  ArrayList<FriendDto> search(String fname,String tel){
		ArrayList<FriendDto> dto = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND WHERE FNAME LIKE '%'||?||'%' AND TEL LIKE '%'||?||'%'";
		
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			pstmt.setString(2, tel);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int n = rs.getInt("n");
				fname = rs.getString("fname");
				tel = rs.getString("tel");
				dto.add(new FriendDto(n,fname,tel));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) { }
		}
		
		return dto;
	}
}
