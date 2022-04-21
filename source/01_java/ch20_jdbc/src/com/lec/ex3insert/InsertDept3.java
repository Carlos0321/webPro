package com.lec.ex3insert;
//부서번호를 입력받아 중복체크 확인후 입력진행 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept3 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
			stmt = conn.createStatement(); // (3)
		while(true) {
				System.out.println("입력할 부서번호는 ? ");
				int deptno = sc.nextInt();
				// 부서번호 중복체크
			String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt != 0) {
				System.out.println("중복된 부서번호는 입력이 불가능합니다");
				continue;

			} 
				System.out.println("입력할 부서명은 ?");
				String dname = sc.next();
				System.out.println("입력할 부서의 위치는 ? ");
				String loc = sc.next();
				String sql1 = "INSERT INTO DEPT VALUES (\"+deptno+\",'\"+dname+\"','\"+loc+\"')";
				sql1 = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')", dname);
				int result = stmt.executeUpdate(sql1);
				System.out.println("입력성공");
				break;
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			try { // (7)
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
}