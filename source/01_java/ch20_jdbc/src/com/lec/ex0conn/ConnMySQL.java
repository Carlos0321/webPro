package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimDB?serverTimezone=UTC";
		Connection conn = null;  //null 안넣으면 
		try {
			Class.forName(driver); // 1.드라이버 로드
			System.out.println("드라이버 로드 성공");
			try {
				conn = DriverManager.getConnection(url, "root", "mysql");
				System.out.println("Mysql DB 연결 성공");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				
			}
		}
	}

}
