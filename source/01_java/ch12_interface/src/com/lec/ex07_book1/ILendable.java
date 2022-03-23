package com.lec.ex07_book1;
//Book에 작업명세서
public interface ILendable {
	public byte STATE_BORROWED = 1;  //대출중
	public byte STATE_NORMAL = 0 ;   //대출되지 않은 상태 "대출가능"을 의미
	public void checkOut(String borrower, String checkOutDate);  //대출시 대출인과 대출일 이용  
	public void checkIn();  //반납
	public void printState(); //도서정보와 대출 상태 출력 
}
