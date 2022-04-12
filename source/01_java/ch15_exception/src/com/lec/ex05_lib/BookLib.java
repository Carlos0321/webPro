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
	private byte state;  //������(1) or ���Ⱑ��(0)
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	// BookLib book = new BookLib("89a-01","java","ȫ�浿")
	// book.checkOut("�ű浿") : �������� Ȯ�� -> ������� -> �������� ���
	@Override
	public void checkOut(String borrwer) throws Exception {
		if(state==STATE_BORROWED) {
			throw new Exception(bookTitle+"������ ���� �� �Դϴ� "); //������ ���ܹ߻� 
		}
		//���� ����
		this.borrower = borrower;
		checkOut = new Date();
		state = STATE_BORROWED; 
		//"java" ������ ����Ǿ����ϴ�. ������ :�ű浿 ������:2022-04-04 2���̳��� �ݳ��Ͻÿ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d(E)");
		System.out.println("\""+bookTitle+"\"+������ ����Ǿ����ϴ�");
		System.out.println("������ : "+ borrwer+ "/ ������ :"+sdf.format(checkOut)+"2�ֳ��� �ݳ��Ͻÿ�");
		
	}
	//book.checkIn() : �������� Ȯ�� => ��ü���� Ȯ�� ->(if ��ü�Ǿ��� ��� ��ü�� ���� y/n) ->�ݳ����� -> ������� 
	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NORMAL) {
			throw new Exception(bookTitle + "������ �������� �ƴմϴ�");
		}
		//��ü���� Ȯ�� checkout ~ ������� 14�� �̳����� ���� 
		Date now = new Date();
		long diff = now.getTime() -checkOut.getTime(); //���� �������� ��������� �и����� 
		long day = diff / (int)(1000*3600*24);
		if(day > 14) {//
			System.out.println("��ü��� ���� 100�� �ΰ��˴ϴ�. ���ž��� ��ü���" + (day-14)*100+"��");
			Scanner sc = new Scanner(System.in);  //��ü�� ���ϸ� ��ĳ�� �ʿ��� ���⿡�� �������� 
			System.out.println("��ü�Ḧ ���̳��� (Yes/NO) ? ");
			if( !sc.next().equalsIgnoreCase("y")) { //��ü�Ḧ �´ٰ� y�� �Է����� ������� 
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �����մϴ�. ��ü�Ḧ ������");
				return;   // ���� �������ܰ迡�� ����?  void�⶧���� ����Ÿ����   ~ 
			}
		}
		//�ݳ�����
		borrower = null; //�ּҸ� ���� �� �ִ� �Ϳ��� null���� 
		checkOut = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle + "\"������ �ݳ��Ǿ����ϴ�");
	}
	//sysout(book) 	->å��ȣ : 89a-01 å�̸�:java ���� ȫ�浿 ���Ⱑ�� 
	//				->å��ȣ : 89a-01 å�̸�:java ���� ȫ�浿 ������(�ݳ�������: 2022-4-4(��))
	@Override
	public String toString() {
		String msg = "å��ȣ : "+bookNo+"\tå�̸�"+bookTitle+ "\t���� :"+writer;
		msg += (state == STATE_NORMAL) ? "\t���Ⱑ��" : "\t���� ��";
		if(state == STATE_BORROWED) {
//			//�������� + 14�� 
//			Date date = new Date(checkOut.getTime()+(1000*3600*24*14));
			SimpleDateFormat sdf = new SimpleDateFormat("(������: yyyy-M-d(E))");
			msg += sdf.format(checkOut);
		}
		return msg;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
}
