package com.lec.ex07_book1;
// Book b = new Book ("890��101-1��" "�׸��� �ƹ���������" "���ż� ũ����Ƽ")
public class Book implements ILendable {
	private String bookNo;     //å��ȣ 
	private String bookTitle;  //å ����
	private String writer;    //����
	private String borrower;  //������
	private String checkOutDate; //������
	private byte state ; // ���� ����   static�̶� byte�� �� ������(1) ���Ⱑ��(0)
	
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}// b.checkOut() ; ���� : ���¸� Ȯ���ؼ� �������̸� �ߴ�, ���Ⱑ���̸� ����ó�� 
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { //�������̸� �޼��� �Ѹ��� �� 
			System.out.println(bookTitle + "������ �������Դϴ�");
			return;   //return ���� 0�̳� �ʱⰪ ���ص� �Ǵ� ���� 
		}
		// state�� 0�̶� ����ó�� ���� else { // ����ó��
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED; //������ ���·� ��ȯ 
			System.out.println(bookTitle + "������ ���� ó���Ǿ����ϴ�");
			System.out.println("������ : " + borrower +"\t������ : " + checkOutDate);
		}
		
	
	// b.checkIn() : state Ȯ���ؼ�  ���Ⱑ��(0)�̸� �޼��� �Ѹ��� �ߴ�, ������(1)�̸� �ݳ����� 
	@Override
	public void checkIn() { 
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle + "������ �ݳ��Ϸ�� å�ε� �̻��մϴ�. ���ܹ߻�");
			return;
		}
		//state�� ������(1)�̶� �ݳ����� 
		borrower = null;   // null�� �ؾߵǴ� ���� �����ϱ�  
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle +"��(��) �ݳ��Ϸ�Ǿ����ϴ� ");
	}
	// b.printState() => "890��101-1��" "�׸��� �ƹ���������" "���ż� ũ����Ƽ" ������
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "\t" + writer +"����" + "\t���� ����");
		}else if(state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "\t" + writer +"����" + "\t������");
		}else{
			System.out.println(bookNo + "\t" + bookTitle + "\t" + writer +"����" + "\t����");
		}
//		String msg =bookNo + "\t" + bookTitle + "\t" + writer +"����";
//		msg = msg + ((state == STATE_NORMAL) ? "���Ⱑ��" : (state ==STATE_NORMAL) ? "������" : "����");
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
