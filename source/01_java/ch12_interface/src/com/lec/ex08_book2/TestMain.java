package com.lec.ex08_book2;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		BookLib[] book = { 	new BookLib("110-234ㅁ-1", "python", "김민석"), 
							new BookLib("113-411ㄱ-3", "java", "김민우"),
							new BookLib("112-556ㅊ-6", "oracle", "Carlos"),
							new BookLib("111-248ㅅ-9", "jsp", "토치")};
		
		Scanner sc = new Scanner(System.in); // 사용자가 입력하기 위해 스캐너 설정 
		int fn; // 기능 번호 (1:대출 , 2:반납 , 3:책리스트 , 0:종료 
		int idx;  //대출하거나 반납하려고 할때 조회된 책의 index 
		String bTitle, borrower, checkOutDate; //사용자에게 받을 책 이름, 대출인, 대출 날짜
		do {//  
			System.out.println(("1:대출 | 2:반납| 3:책list| 0:종료"));
			fn = sc.nextInt();  // 스캐너를 이용해서 입력받기 
			switch (fn) { //대출처리 : 1.책이름 입력  2.책 조회  3.책상태확인 4.대출인 입력 5.대출날짜 6.대출메소드 호출 checkout
			case 1: //1. 책 이름 입력 
				System.out.println("대출 하고자 하는 책 이름은 ? : ");
				bTitle = sc.next(); // 사용자가 대출하려는 책 입력받는 메소드 
				for (idx = 0; idx < book.length; idx++) {
					if (book[idx].getBookTitle().equals(bTitle)) {
						//book이라는 배열방 안에 idx라는 인덱스 변수가 들어있고, title상속받고 btitle과 비교 
						break;
					}
				}
				if (idx == book.length) { 
					System.out.println("현재 보유하지 않은 도서입니다");
				} else {
					if (book[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("죄송합니다 현재 대출중인 도서입니다.");
					} else {
						System.out.println("대출자 : ");
						borrower = sc.next();
						System.out.println("대출 날짜 : ");
						checkOutDate = sc.next();
						book[idx].checkOut(borrower, checkOutDate);  
					}
				}
				break;
			case 2:
				System.out.println("반납할 책 이름은 ? : ");
				bTitle = sc.next();
				for (idx = 0; idx < book.length; idx++) {
					if (book[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if (idx == book.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
				} else {
					book[idx].chekIn();
				}
				break;
			case 3:
				System.out.println("책 리스트는 다음과 같습니다");
				for (BookLib b : book) {
					b.printState();
				}
			case 0:
				break;
			}// switch

		} while (fn != 0);
		System.out.println("BYE");

	}// main

}// class
