package com.lec.quiz;
import java.util.Scanner;
// �� ���� �Է¹޾� �� ���� ������ ����� o�� x�� ��� , ù��° ���� �� ū�� ����� o�� X�� ���
public class Quiz3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("ù��° ���� �Է� �ϼ���:");
		 int su1 = scanner.nextInt();
		 
		 Scanner scanner1 = new Scanner(System.in);
		 System.out.println("�ι�° ���� �Է��ϼ���:");
		 int su2 = scanner.nextInt();
		 
		 String result ;		
		 if (su1==su2) {
				result = "O";
			}else {
				result = "X";
			}
		 System.out.println(result);
	}

}
