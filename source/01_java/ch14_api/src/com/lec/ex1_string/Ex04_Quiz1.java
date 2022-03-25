package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;

		System.out.println("주민번호를 입력하세요 : ");
		fn = sc.next();
		if ('1' == fn.charAt(7)) {
			System.out.println("남자");
		} else if ('2' == fn.charAt(7)) {
			System.out.println("여자");

		}
		sc.close();
	}

}
