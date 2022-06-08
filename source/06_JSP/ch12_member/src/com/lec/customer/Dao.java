package com.lec.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.member.MemberDto;

public class Dao {
	public static final int SUCCESS = 1; 
	public static final int FAIL = 0;
	public static final int EXISTENT= 0;
	public static final int NONEXISTENT= 1;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL = 0;
	
	private static Dao instance;
	public static Dao getInstance() {
		if(instance ==null) {
			instance = new Dao();
		}
		return instance;
	}
	public Connection getConnection() throws SQLException {
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
	//회원가입 ID 중복체크
	public int confirmID(String cid) {
		int result = EXISTENT;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs =null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=EXISTENT;
			}else {
				result = NONEXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				
			}
		}
		return result;
		
	}
	// 회원가입
	public int joinCustomer(Dto dto) {
		int result =FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL,CADDRESS, CGENDER,CBIRTH,CRDATE)" + 
				"    VALUES (?,?,?,?,?,?,?,?,SYSDATE) ";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7, dto.getCgender());
			pstmt.setTimestamp(8, dto.getCbirth());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원 가입 실패 :"+dto);
		}
		
		return result;
		
	}
	//로그인 
	public int login(String cid, String cpw) {
		int result = LOGIN_FAIL;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet		  rs =null;
		String sql = "SELECT CID,CPW FROM CUSTOMER WHERE CID=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("cid");
				String pw = rs.getString("cpw");
				if(id.equals(cid)&&pw.equals(cpw)) {
					result = LOGIN_SUCCESS;
				}else {
					result = LOGIN_FAIL;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				
			}
		}
		
		return result;
	}
	// CID로 DTO 가져오기
	public Dto getCustomer(String cid) {
		Dto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs =null;
		String sql = "SELECT *FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection(); //(2)
			pstmt = conn.prepareStatement(sql); //(3)
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery(); //(4)+(5)
			String cpw = rs.getString("cpw");
			String cname = rs.getString("cname");
			String ctel = rs.getString("ctel");
			String cmail = rs.getString("cmail");
			String caddress = rs.getString("caddress");
			String cgender = rs.getString("cgender");
			Timestamp cbirth = rs.getTimestamp("cbirth");
			Date crdate = rs.getDate("crdate");
			dto = new Dto(cid, cpw, cname, ctel, cmail, caddress, cgender, cbirth, crdate);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				
			}
		}
		return dto;
	}
	public int modifyCustomer(Dto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE  CUSTOMER SET" + 
				"CPW=?, CNAME=?, CTEL=?, CGENDER=? , CEMAIL=?, CADDRESS=?";
		
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCgender());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원정보 수정실패:"+dto.toString());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				
			}
		}
		return result;
	}
}
