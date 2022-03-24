package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		Book[] books = {new Book("890ㅁ101-1ㄱ", "python", "김민우"), 
				 		new Book("110ㄱ-234-5ㅈ", "java", "Carlos"),
				 		new Book("110ㄴ-432-2ㄱ", "oracle", "토치"), 
				 		new Book("778ㅅ-432-2ㅌ", "jsp", "메가스터디"),
				 		new Book("110ㄱ-234-5ㅈ", "spring", "집에가고싶다") };

		Scanner sc = new Scanner(System.in);
		int fn; // 기능 번호 (1:대출| 2:반납| 3:책list |0:종료)
		int idx; // 대출하거나 반납하려고 할때 조회된 책의 index
		String bTitle, borrower, checkOutDate; // 사용자에게 받을 책 이름, 대출인, 대출일
		do {
			System.out.println(("1:대출| 2:반납| 3:책list |0:종료"));
			fn = sc.nextInt();
			switch (fn) {
			case 1: 
				//대출처리 : 1.책이름 입력  2.책 조회  3.책상태확인 4.대출인 입력 5.대출날짜 6.대출메소드 호출 checkout
				//1. 책 이름 입력 
				System.out.print("대출하고자 하는 책 이름은 ? : ");
				bTitle = sc.next(); //white-space 앞까지의 스트링만 받음 
				//2. 책 조회 
				
				for(idx = 0; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}//2. 책조회 for
				if(idx == books.length) {
					System.out.println("현재 보유하지 않은 도서입니다");
				}else { //book[idx] 도서를 대출 처리 
					//3. 책 상태확인
					if(books[idx].getState() == Book.STATE_BORROWED) {  //대출불가 상태 
						System.out.println("죄송합니다 현재 대출중인 도서입니다.");
					}else { //대출가능 상태 
						//4. 대출인 입력 5. 대출 날짜 입력 6. 대출 메소드 호출 
						System.out.println("대출자는 ? : ");
						borrower = sc.next();
						System.out.println("대출 날짜는 ? : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate); // 질문
						}
				}
				break;
			case 2: //반납 : 1. 책이름 2.책조회 3.반납 
				// 1. 책이름 
				System.out.println("반납할 책 이름은? : ");
				bTitle = sc.next();
				//2. 책조회 
				for(idx = 0; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx==books.length) {  // 질문 
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {//idx가 찾은 그 위치 
					//3. 반납
					books[idx].checkIn();
				}
				
				break;
			case 3:
				System.out.println("책 리스트는 다음과 같습니다");
//				books[0].printState();
				for(Book b : books) {
					b.printState();
				}
			case 0 :break;
			
			}
		}while(fn!=0);
		System.out.println("BYE");
//		while (true) {
//			System.out.println("1:대출| 2:반납| 3:책list |0:종료");
//			fn = sc.nextInt();
//			if (fn == 0) {
//				break;
//			}
//		}
	}// main
}// class
