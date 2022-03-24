package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		Book[] books = {new Book("890��101-1��", "python", "��ο�"), 
				 		new Book("110��-234-5��", "java", "Carlos"),
				 		new Book("110��-432-2��", "oracle", "��ġ"), 
				 		new Book("778��-432-2��", "jsp", "�ް����͵�"),
				 		new Book("110��-234-5��", "spring", "��������ʹ�") };

		Scanner sc = new Scanner(System.in);
		int fn; // ��� ��ȣ (1:����| 2:�ݳ�| 3:ålist |0:����)
		int idx; // �����ϰų� �ݳ��Ϸ��� �Ҷ� ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate; // ����ڿ��� ���� å �̸�, ������, ������
		do {
			System.out.println(("1:����| 2:�ݳ�| 3:ålist |0:����"));
			fn = sc.nextInt();
			switch (fn) {
			case 1: 
				//����ó�� : 1.å�̸� �Է�  2.å ��ȸ  3.å����Ȯ�� 4.������ �Է� 5.���⳯¥ 6.����޼ҵ� ȣ�� checkout
				//1. å �̸� �Է� 
				System.out.print("�����ϰ��� �ϴ� å �̸��� ? : ");
				bTitle = sc.next(); //white-space �ձ����� ��Ʈ���� ���� 
				//2. å ��ȸ 
				
				for(idx = 0; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}//2. å��ȸ for
				if(idx == books.length) {
					System.out.println("���� �������� ���� �����Դϴ�");
				}else { //book[idx] ������ ���� ó�� 
					//3. å ����Ȯ��
					if(books[idx].getState() == Book.STATE_BORROWED) {  //����Ұ� ���� 
						System.out.println("�˼��մϴ� ���� �������� �����Դϴ�.");
					}else { //���Ⱑ�� ���� 
						//4. ������ �Է� 5. ���� ��¥ �Է� 6. ���� �޼ҵ� ȣ�� 
						System.out.println("�����ڴ� ? : ");
						borrower = sc.next();
						System.out.println("���� ��¥�� ? : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate); // ����
						}
				}
				break;
			case 2: //�ݳ� : 1. å�̸� 2.å��ȸ 3.�ݳ� 
				// 1. å�̸� 
				System.out.println("�ݳ��� å �̸���? : ");
				bTitle = sc.next();
				//2. å��ȸ 
				for(idx = 0; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx==books.length) {  // ���� 
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				}else {//idx�� ã�� �� ��ġ 
					//3. �ݳ�
					books[idx].checkIn();
				}
				
				break;
			case 3:
				System.out.println("å ����Ʈ�� ������ �����ϴ�");
//				books[0].printState();
				for(Book b : books) {
					b.printState();
				}
			case 0 :break;
			
			}
		}while(fn!=0);
		System.out.println("BYE");
//		while (true) {
//			System.out.println("1:����| 2:�ݳ�| 3:ålist |0:����");
//			fn = sc.nextInt();
//			if (fn == 0) {
//				break;
//			}
//		}
	}// main
}// class
