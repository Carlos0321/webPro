package com.lec.condition;

import java.util.Scanner;

// ����ڷκ��� ������ �Է¹޾� ���� ���
public class Ex04_if_hakjum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("���� : ");
		int score = sc.nextInt();
		int temp = score == 100 ? score - 1 : score;   //
		temp = (-9<=temp && temp<0)? -10 : temp;
		switch (score / 10) { // ����Բ� ���� /10�ϴ� ����

		case 10:System.out.println();
		case 9: System.out.println("A����"); break;
		case 8: System.out.println("B����"); break;
		case 7: System.out.println("C����"); break;
		case 6: System.out.println("D����"); break;

		case 5:	case 4: case 3:	case 2:	case 1:	case 0:
			System.out.println("F����");	break;
		default:
			System.out.println("��ȿ�����ʴ� �����Դϴ�");

//		if( (90 <= score) && score <= 100) {
//		System.out.println("A����");
//		} else if( (80 <= score) && score <= 90) {
//		   System.out.println("B����"); 
//	    } else if( (70 <= score) && score <= 80) {
//	    System.out.println("C����");
//	    } else if( (60 <= score) && score <= 70) {
//		    System.out.println("D����");
//	    } else if( (0 <= score) && score <= 60) {
//		    System.out.println("F����") ;
//	}else {
//		System.out.println("��ȿ�� ������ �ƴմϴ�");
		}
	}
}