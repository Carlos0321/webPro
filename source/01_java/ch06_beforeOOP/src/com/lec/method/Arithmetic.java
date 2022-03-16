package com.lec.method;

public class Arithmetic {
	public int abs(int value) {
		int result = (value >= 0) ? value : -value ;
		return result ;
	}
	
	
		public static int sum(int to) {  //함수의 오버로딩
			int result = 0 ;//from ~to까지 누적한 결과 return
			for(int i=1 ; i <= to ; i++) {
				 result +=i;   //result = result + i ;
			}
			return result;
		}
	public static int sum(int from, int to) { //지역변수  다른파일에서 사용안할때 private 사용
			int result = 0 ;//from ~to까지 누적한 결과 return
			for(int i=from ; i <= to ; i++) {
				 result +=i;   //result = result + i ;
			}
			return result; // 누적한 결과 
		}
		public static String evenOdd(int value) {
			return value%2 == 0 ? "짝수입니다" : "홀수입니다" ;
	}

}
