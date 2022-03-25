package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_Quiz2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;
		do {
			System.out.println("번호를 입력하세요 : ");
			tel = sc.next();
			System.out.println("");
		}
		while(! tel.equalsIgnoreCase("x"));
		System.out.println("종료");
	}

} 


