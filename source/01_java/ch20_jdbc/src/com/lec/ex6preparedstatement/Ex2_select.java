package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//사용자로부터 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오 
public class Ex2_select {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("부서명을 입력하세요");
		String dname= sc.next();
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + 
				"    FROM EMP E , DEPT D" + 
				"    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER(?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				do { //EMPNO, ENAME, SAL, GRADE
					int empno= rs.getInt("empno");
					String ename=rs.getString("ename");
					String job =rs.getString("job");
					int sal=rs.getInt("sal");
					System.out.println(empno+"\t"+ename+"\t"+ job+"\t"+ sal );
					
				}while(rs.next());
			}else {
				System.out.println("해당 부서는 없습니다.");
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null) 
					conn.close();
			} catch (SQLException e) {
			}
		}

	}

}