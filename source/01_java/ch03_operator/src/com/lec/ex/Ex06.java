package com.lec.ex;
//삼항 연산자 : (조건)  ? (참일경우 취할 값or 식): (거짓일 경우 취할 값 or 식)
public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h = 100;
		String result ;
		result = (h%2==0) ? "짝수" : "홀수";  //로그인 성공, 패스워드가 틀렸습니다.
//		if (h%2==0) {
//			result = "짝수";
//		}else {
//			result = "홀수";
//		}
		System.out.println(result);
	}

}
