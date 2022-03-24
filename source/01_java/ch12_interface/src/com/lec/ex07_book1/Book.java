package com.lec.ex07_book1;
// Book b = new Book ("890ㅁ101-1ㄱ" "그리고 아무도없었다" "에거서 크리스티")
public class Book implements ILendable {
	private String bookNo;     //책번호 
	private String bookTitle;  //책 제목
	private String writer;    //저자
	private String borrower;  //대출인
	private String checkOutDate; //대출일
	private byte state ; // 대출 상태   static이라 byte로 함 대출중(1) 대출가능(0)
	
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}// b.checkOut() ; 대출 : 상태를 확인해서 대출중이면 중단, 대출가능이면 대출처리 
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { //대출중이면 메세지 뿌리고 끝 
			System.out.println(bookTitle + "도서는 대출중입니다");
			return;   //return 질문 0이나 초기값 안해도 되는 이유 
		}
		// state가 0이라 대출처리 진행 else { // 대출처리
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED; //대출중 상태로 전환 
			System.out.println(bookTitle + "도서가 대출 처리되었습니다");
			System.out.println("대출인 : " + borrower +"\t대출일 : " + checkOutDate);
		}
		
	
	// b.checkIn() : state 확인해서  대출가능(0)이면 메세지 뿌리고 중단, 대충중(1)이면 반납진행 
	@Override
	public void checkIn() { 
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle + "도서는 반납완료된 책인데 이상합니다. 예외발생");
			return;
		}
		//state가 대출중(1)이라 반납진행 
		borrower = null;   // null을 해야되는 이유 질문하기  
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle +"이(가) 반납완료되었습니다 ");
	}
	// b.printState() => "890ㅁ101-1ㄱ" "그리고 아무도없었다" "에거서 크리스티" 대출중
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "\t" + writer +"지음" + "\t대출 가능");
		}else if(state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "\t" + writer +"지음" + "\t대출중");
		}else{
			System.out.println(bookNo + "\t" + bookTitle + "\t" + writer +"지음" + "\t오류");
		}
//		String msg =bookNo + "\t" + bookTitle + "\t" + writer +"지음";
//		msg = msg + ((state == STATE_NORMAL) ? "대출가능" : (state ==STATE_NORMAL) ? "대출중" : "오류");
//		System.out.println(msg);
}
	public String getBookNo() {
		return bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public String getBorrower() {
		return borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public byte getState() {
		return state;
	}

}
