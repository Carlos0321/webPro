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
			System.out.println(getBookTitle() + "������ �������Դϴ�");
			return;
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getBookTitle() + "������ ���� ó���Ǿ����ϴ�");
		System.out.println("������ : " + borrower + "\t���⳯¥ :" + chekOutDate);
	}

	@Override
	public void chekIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "������ �ݳ� �Ϸ�� å�Դϴ� ���� �߻�");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "��(��) �ݳ��Ϸ�Ǿ����ϴ�.");
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + getWriter() + "����" + "\t���� ����");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + getWriter() + "����" + "\t������ ");
		} else {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + getWriter() + "����" + "\t����");
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
