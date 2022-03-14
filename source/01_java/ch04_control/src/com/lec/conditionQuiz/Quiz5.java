package com.lec.conditionQuiz;

import java.util.Scanner;

// 0 <= Math.random() <1
// 0 <= Math.random()*3 < 3
// 0 <= (int)(Math.random()*3) : 0,1,2 중의 하나
public class Quiz5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int you, computer = (int) (Math.random() * 3); // 0,1,2
		System.out.println("가위(0), 바위(1), 보(2) 중에 하나를 선택하시오 : ");
		you = sc.nextInt(); // 정수를 받음
		if (you == 0) {
			System.out.print("당신은 가위\n");
		} else if (you == 1) {
			System.out.print("당신은 바위\n");

		} else if (you == 2) {
			System.out.print("당신은 보\n");
		} else {
			System.out.print("당신은 잘못 냈어요. 바이");
			you = 3; // 끝내기 위한 조건
		}
		if (you != 3) { // 컴퓨터가 낸 것과 승패 출력
			String msg = (computer == 0) ? "컴퓨터는 가위" : (computer == 1) ? "컴퓨터는 바위" : "컴퓨터는 보자기";
			System.out.println(msg);
			// 승패 출력
			if (you == 0) {
				if (computer == 0) {
					System.out.println("비겼다");
				} else if (computer == 1) {
					System.out.println("컴퓨터가 이겼다");
				} else {
					System.out.println("당신이 이겼다");
				} // if 출력
			} else if (you == 1) {
				if (computer == 0) {
					System.out.println("당신이 이겼다");
				} else if (computer == 1) {
					System.out.println("비겼다 ");
				} else {
					System.out.println("컴퓨터가 이겼다");
				} // if 출력
			} else if (you == 2) {
				if (computer == 0) {
					System.out.println("컴퓨터가 이겼다");
				} else if (computer == 1) {
					System.out.println("당신이 이겼다");
				} else {
					System.out.println("비겼다");
				} // if출력
			} // if -승패 출력
		} // if
	} // main
}// class