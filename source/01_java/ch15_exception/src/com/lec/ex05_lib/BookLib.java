package com.lec.ex05_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkOut;
	private byte state;  //대출중(1) or 대출가능(0)
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	// BookLib book = new BookLib("89a-01","java","홍길동")
	// book.checkOut("신길동") : 도서상태 확인 -> 대출로직 -> 도서상태 출력
	@Override
	public void checkOut(String borrwer) throws Exception {
		if(state==STATE_BORROWED) {
			throw new Exception(bookTitle+"도서는 대출 중 입니다 "); //강제로 예외발생 
		}
		//대출 로직
		this.borrower = borrower;
		checkOut = new Date();
		state = STATE_BORROWED; 
		//"java" 도서가 대출되었습니다. 대출인 :신길동 대출일:2022-04-04 2주이내에 반납하시오
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d(E)");
		System.out.println("\""+bookTitle+"\"+도서가 대출되었습니다");
		System.out.println("대출인 : "+ borrwer+ "/ 대출일 :"+sdf.format(checkOut)+"2주내로 반납하시오");
		
	}
	//book.checkIn() : 도서상태 확인 => 연체여부 확인 ->(if 연체되었을 경우 연체료 납부 y/n) ->반납로직 -> 상태출력 
	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NORMAL) {
			throw new Exception(bookTitle + "도서는 대출중이 아닙니다");
		}
		//연체여부 확인 checkout ~ 현재까지 14일 이내인지 여부 
		Date now = new Date();
		long diff = now.getTime() -checkOut.getTime(); //대출 시전부터 현재까지의 밀리세컨 
		long day = diff / (int)(1000*3600*24);
		if(day > 14) {//
			System.out.println("연체료는 일일 100원 부가됩니다. 내셔야할 연체료는" + (day-14)*100+"원");
			Scanner sc = new Scanner(System.in);  //연체를 안하면 스캐너 필요없어서 여기에다 변수선언 
			System.out.println("연체료를 내셨나요 (Yes/NO) ? ");
			if( !sc.next().equalsIgnoreCase("y")) { //연체료를 냈다고 y를 입력하지 않은경우 
				System.out.println("연체료를 내셔야 반납처리가 가능합니다. 연체료를 내세요");
				return;   // 질문 마무리단계에서 쓰는?  void기때문에 리턴타입이   ~ 
			}
		}
		//반납로직
		borrower = null; //주소를 담을 수 있는 것에는 null가능 
		checkOut = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle + "\"도서가 반납되었습니다");
	}
	//sysout(book) 	->책번호 : 89a-01 책이름:java 저자 홍길동 대출가능 
	//				->책번호 : 89a-01 책이름:java 저자 홍길동 대출중(반납예정일: 2022-4-4(월))
	@Override
	public String toString() {
		String msg = "책번호 : "+bookNo+"\t책이름"+bookTitle+ "\t저자 :"+writer;
		msg += (state == STATE_NORMAL) ? "\t대출가능" : "\t대출 중";
		if(state == STATE_BORROWED) {
//			//빌린시점 + 14일 
//			Date date = new Date(checkOut.getTime()+(1000*3600*24*14));
			SimpleDateFormat sdf = new SimpleDateFormat("(대출일: yyyy-M-d(E))");
			msg += sdf.format(checkOut);
		}
		return msg;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
}
