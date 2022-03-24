package com.lec.ex08_book2;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		BookLib[] book = { 	new BookLib("110-234��-1", "python", "��μ�"), 
							new BookLib("113-411��-3", "java", "��ο�"),
							new BookLib("112-556��-6", "oracle", "Carlos"),
							new BookLib("111-248��-9", "jsp", "��ġ")};
		
		Scanner sc = new Scanner(System.in); // ����ڰ� �Է��ϱ� ���� ��ĳ�� ���� 
		int fn; // ��� ��ȣ (1:���� , 2:�ݳ� , 3:å����Ʈ , 0:���� 
		int idx;  //�����ϰų� �ݳ��Ϸ��� �Ҷ� ��ȸ�� å�� index 
		String bTitle, borrower, checkOutDate; //����ڿ��� ���� å �̸�, ������, ���� ��¥
		do {//  
			System.out.println(("1:���� | 2:�ݳ�| 3:ålist| 0:����"));
			fn = sc.nextInt();  // ��ĳ�ʸ� �̿��ؼ� �Է¹ޱ� 
			switch (fn) { //����ó�� : 1.å�̸� �Է�  2.å ��ȸ  3.å����Ȯ�� 4.������ �Է� 5.���⳯¥ 6.����޼ҵ� ȣ�� checkout
			case 1: //1. å �̸� �Է� 
				System.out.println("���� �ϰ��� �ϴ� å �̸��� ? : ");
				bTitle = sc.next(); // ����ڰ� �����Ϸ��� å �Է¹޴� �޼ҵ� 
				for (idx = 0; idx < book.length; idx++) {
					if (book[idx].getBookTitle().equals(bTitle)) {
						//book�̶�� �迭�� �ȿ� idx��� �ε��� ������ ����ְ�, title��ӹް� btitle�� �� 
						break;
					}
				}
				if (idx == book.length) { 
					System.out.println("���� �������� ���� �����Դϴ�");
				} else {
					if (book[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("�˼��մϴ� ���� �������� �����Դϴ�.");
					} else {
						System.out.println("������ : ");
						borrower = sc.next();
						System.out.println("���� ��¥ : ");
						checkOutDate = sc.next();
						book[idx].checkOut(borrower, checkOutDate);  
					}
				}
				break;
			case 2:
				System.out.println("�ݳ��� å �̸��� ? : ");
				bTitle = sc.next();
				for (idx = 0; idx < book.length; idx++) {
					if (book[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if (idx == book.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				} else {
					book[idx].chekIn();
				}
				break;
			case 3:
				System.out.println("å ����Ʈ�� ������ �����ϴ�");
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
