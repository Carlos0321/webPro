package com.lec.ex3_math;

public class Ex01_Math {
	public static void main(String[] args) {
		int a = 2, b = 10;
		System.out.println("2의 10승은 ? "+Math.pow(a, b));
		System.out.println("-9.9의 절대값은? " +Math.abs(-9.9));
		System.out.println("4의 제곱근은? "+ Math.sqrt(4));
		System.out.println("a와 b 중 최소값은 ? "+Math.min(a, b));
		System.out.println("최대값? "+Math.max(a, b));
		// math의 변수 (static final변수)
		System.out.println("PI값은 ? " + Math.PI);
	}
}
