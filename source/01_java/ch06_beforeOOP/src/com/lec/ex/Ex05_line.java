package com.lec.ex;
/*  ����������������
 *  Hello, World!
 *  ---------printLine()
 *  Hello, Java
 *  ~~~~~~~~~~~
 *  ������������
 *  Hello Kim!
 */
public class Ex05_line {

	public static void main(String[] args) {
		printLine('��', 50);  //���� �� ���ʵ����� �������� �̰� ������ 
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, Kim!");
		printLine('��', 40);
	}
	private static void printLine(char c, int cnt) {
		for(int i =0; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	private static void printLine(int cnt) {
		for(int i =0; i<cnt ; i++) {// ���� '-' cnt�� ����ϰ� ���� 
			System.out.print('-');
		}
		System.out.println(); // �β��� '-'40�� ����ϰ� ���� 
	}
	
	private static void printLine(char c) { //�Լ� �����ε�(���� �̸��� �Լ��� �Ű������� ����) // �Ű����� Ÿ������ ���� ,
		for(int i =0; i<30 ; i++) {
			System.out.print(c);
		}
		System.out.println(); //�Ű������� ���� c���� 30�� ����ϰ� ����
	}
	
	private static void printLine( ) { //����Ÿ���� ���� �Ű����� ���� �޼ҵ�
		for(int i =0; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); // ���� '-'20�� ����ϰ� ���� 
	}
}