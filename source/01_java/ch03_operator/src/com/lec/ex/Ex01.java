package com.lec.ex;
// 산술연산자 : + , -, *, / %
public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 33, n2 = 10;
		int result; // + - * %의 결과
		double resultDouble; // /의 결과 
		result = n1 + n2 ;
		System.out.printf("%d %c %d = %d\n", n1,'+', n2, result); //33+10 =43
		result = n1 - n2 ;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1 * n2 ;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 % n2 ; // 나머지 
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		resultDouble = (double)n1 / n2 ;
		System.out.printf("%d %c %d = %f\n", n1, '/', n2, resultDouble);
	}

}
