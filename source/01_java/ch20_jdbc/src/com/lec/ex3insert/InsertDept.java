package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {

	public static void main(String[] args) {
		String 		driver 	= "oracle.jdbc.driver.OracleDriver";
		String 		url 	= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner 	sc		= new Scanner(System.in);
		System.out.println("입력할 부서번호는 ? ");
		int deptno = sc.nextInt();
		System.out.println("입력한 부서명은 ? ");
		String	dname  = sc.next();
		System.out.println("입력할 부서위치는? ");
		String loc = sc.next();
		String sql = "INSERT INTO DEPT VALUES ("+deptno+",'"+dname+"','"+loc+"')";
		sql = String.format("INSERT INTO DEPT VALUES (%d, '%s','%s')", deptno,dname,loc);
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver); //(1)
			conn= DriverManager.getConnection(url,"scott","tiger"); //(2)
			stmt= conn.createStatement(); //(3)
			int result = stmt.executeUpdate(sql); //(4) +(5)
			System.out.println(result > 0 ? "입력성공" : "입력실패"); //(6)
	
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류"+e.getMessage());
		}finally {
			try { //(7)
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
			}
		}
	}
}