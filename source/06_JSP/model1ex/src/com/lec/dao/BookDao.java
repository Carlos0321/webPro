package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.BookDto;

public class BookDao {
	public static final int SUCCESS = 1; 
	public final static int FAIL=0;
	
	//싱글톤
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() {
		return instance;
	}
	private BookDao() {}
	//Connection 객체 받아오는 함수
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
	//책 등록 
	public int insertBook(BookDto book) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)" + 
				"    VALUES (BOOK_SEQ.NEXTVAL, ?, ?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, book.getBtitle());
			pstmt.setInt(2,book.getBprice());
			pstmt.setString(3, book.getBimage1());
			pstmt.setString(4, book.getBimage2());
			pstmt.setString(5,book.getBcontent());
			pstmt.setInt(6,book.getBdiscount());
			result = pstmt.executeUpdate();
		//	System.out.println(result==SUCCESS ? "책등록 성공":"책등록 실패");
			System.out.println("책등록 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+book);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//책 목록(전체 list)
	public ArrayList<BookDto> listBook(){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK ORDER BY BRDATE DESC";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int bid =rs.getInt("bid");
				 String btitle= rs.getString("btitle");
				 int bprice = rs.getInt("bprice");
				 String bimage1 =rs.getString("bimage1");
				 String bimage2 = rs.getString("bimage2");
				 String bcontent = rs.getString("bcontent");
				 int bdiscount = rs.getInt("bdiscount");
				 Date brdate = rs.getDate("brdate"); 
				 books.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return books;
	}
	//책목록(paging : startRow~endRow)
	public ArrayList<BookDto> listBook(int startRow,int endRow){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *" + 
				"FROM (SELECT  ROWNUM RN, A.* FROM(SELECT * FROM BOOK ORDER BY BRDATE DESC) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int bid =rs.getInt("bid");
				 String btitle= rs.getString("btitle");
				 int bprice = rs.getInt("bprice");
				 String bimage1 =rs.getString("bimage1");
				 String bimage2 = rs.getString("bimage2");
				 String bcontent = rs.getString("bcontent");
				 int bdiscount = rs.getInt("bdiscount");
				 Date brdate = rs.getDate("brdate"); 
				 books.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return books;
	}
	//등록된 책 개수 
	public int getBookTotcnt() {
		int bookTotalcnt = 0 ;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOOK";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			//무조건 한 행이 출력 되므로  while문 필요 x
			bookTotalcnt = rs.getInt("cnt"); //엘리아스 타이틀을 넣어줘야한다  특수문자면 1번째 열 가져옴
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return bookTotalcnt;
	}
	// 책 상세보기(bId로 dto 가져오기)
	public BookDto getBook(int bid) { // 리턴타입 BookDto
		BookDto book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE BID=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			//bid가 프라이머리 키라서 한줄 또는 0줄 들어온다  그래서 if문
			if(rs.next()) {
				 String btitle= rs.getString("btitle");
				 int bprice = rs.getInt("bprice");
				 String bimage1 =rs.getString("bimage1");
				 String bimage2 = rs.getString("bimage2");
				 String bcontent = rs.getString("bcontent");
				 int bdiscount = rs.getInt("bdiscount");
				 Date brdate = rs.getDate("brdate"); 
				 book=new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return book;
	}
}
