package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex01_insertDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		
		// 추가할 데이터 받기
		System.out.println("추가할 부서번호 ?");
		int deptno = sc.nextInt();
		System.out.println("추가할 부서 이름 ? ");
		String dname = sc.next();
		System.out.println("추가할 부서 위치? ");
		String loc = sc.next();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DEPT VALUES(?,?,?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); //sql 전송객체
			//stmt = conn.createStatement();
			pstmt.setInt(1,deptno); // sql의 첫번째 물음표에 int값으로 deptno를 setting
			pstmt.setString(2, dname); //두번째 물음표에 String값으로 dname을 setting
			pstmt.setString(3, loc); 
			int result = pstmt.executeUpdate();
			//int result = pstmt.executeUpdate(sql);
			System.out.println(result > 0 ? deptno+"번 부서 입력 성공" : "입력 실패");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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

}