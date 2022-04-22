package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//사용자로부터 삭제하고자 하는 부서번호를 입력받아 삭제하기 
public class DeleteDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null; // close할때 확실히 알기 위해서 null
		Statement stmt = null;
		System.out.println("삭제할 부서 번호는? ");
		int deptno = sc.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement(); // 제대로 수행하지 못하면 catch절로 떨어짐 그래서 null을 넣어줘야함
			int result = stmt.executeUpdate(sql); // 함수 질문
			System.out.println(result > 0 ? deptno + "번 부서 삭제성공" : deptno + "번 부서는 존재하지 않습니다");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 오류" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null) 
					conn.close();
			} catch (SQLException e) {
			}
		}

	}

}
