package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	private DataSource ds ;  //초기화 안해줘도 null 자동 초기화
	
	// 싱글톤
	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	//로그인 체크 
	public int loginChk(String mid, String mpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE mID=? AND mPW=?";
		return result;
		
	}
	//mid로 dto 가져오기 
	public MemberDto getMember(String mid) {
		
	}
	//회원가입 id 중복체크
	public int mIdConfirm(String mid) {
		
	}
	//회원가입
	public int joinMember(MemberDto member) {
		
	}
	//회원 정보 수정 
	public modifyMember(MemberDto member) {
		
	}
	//회원리스트(top-N)
	public ArrayList<MemberDto> allMember(int startRow, int endRow){
		
	}
	public int getMemberTotCnt() {
		
	}
}
