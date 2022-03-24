package com.lec.ex08_book2;

public class BookLib extends BookInfo implements ILendable {

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);

	}

	private String borrower;
	private String checkOutDate;
	private byte state;

	@Override
	public void checkOut(String borrower, String chekOutDate) {
		if (state == STATE_BORROWED) {
			System.out.println(getBookTitle() + "도서는 대출중입니다");
			return;
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getBookTitle() + "도서가 대출 처리되었습니다");
		System.out.println("대출인 : " + borrower + "\t대출날짜 :" + chekOutDate);
	}

	@Override
	public void chekIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "도서는 반납 완료된 책입니다 예외 발생");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "이(가) 반납완료되었습니다.");
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + getWriter() + "지음" + "\t대출 가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + getWriter() + "지음" + "\t대출중 ");
		} else {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + getWriter() + "지음" + "\t오류");
		}
		
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
