package com.lec.ex;
/*  ■■■■■■■■■■■■■■■
 *  Hello, World!
 *  ---------printLine()
 *  Hello, Java
 *  ~~~~~~~~~~~
 *  ■■■■■■■■■■■
 *  Hello Kim!
 */
public class Ex05_line {

	public static void main(String[] args) {
		printLine('■', 50);  //질문 왜 기초데이터 변수없이 이걸 쓰는지 
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, Kim!");
		printLine('■', 40);
	}
	private static void printLine(char c, int cnt) {
		for(int i =0; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	private static void printLine(int cnt) {
		for(int i =0; i<cnt ; i++) {// 얇은 '-' cnt개 출력하고 개행 
			System.out.print('-');
		}
		System.out.println(); // 두꺼운 '-'40개 출력하고 개행 
	}
	
	private static void printLine(char c) { //함수 오버로딩(같은 이름의 함수를 매개변수로 구분) // 매개변수 타입으로 구분 ,
		for(int i =0; i<30 ; i++) {
			System.out.print(c);
		}
		System.out.println(); //매개변수로 받은 c문자 30개 출력하고 개행
	}
	
	private static void printLine( ) { //리턴타입이 없고 매개변수 없는 메소드
		for(int i =0; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); // 얇은 '-'20개 출력하고 개행 
	}
}
