package com.lec.quiz;
import java.util.Scanner;

// �Է��� ���� ¦������ Ȧ������ ��� 
public class Quiz2 {

	public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("���ڸ� �Է��Ͻÿ�: ");
	 int i  = scanner.nextInt() ;
	 
	 String result = i%2==0 ? "¦��" : "Ȧ��";
	 System.out.println(result);
	}

}
