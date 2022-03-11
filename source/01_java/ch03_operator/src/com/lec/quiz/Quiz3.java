package com.lec.quiz;
import java.util.Scanner;
// 두 수를 입력받아 두 수가 같은지 결과를 o나 x로 출력 , 첫번째 수가 더 큰지 결과를 o나 X로 출력
public class Quiz3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("첫번째 수를 입력 하세요:");
		 int su1 = scanner.nextInt();
		 
		 Scanner scanner1 = new Scanner(System.in);
		 System.out.println("두번째 수를 입력하세요:");
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
