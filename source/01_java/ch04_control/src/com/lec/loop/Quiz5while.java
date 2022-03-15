package com.lec.loop;
//너가 질 때까지 가위바위보 게임을 하는 프로그램 
import java.util.Scanner;

public class Quiz5while {

	public static void main(String[] args) {
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
			//경우의 수 3가지 : 졌다, 이겼다, 비겼다 
		//if(you==0 &&computer==1 || (you==1) || (computer==2)) {
		if((you+1)%3 == computer){	
			System.out.println("you가 졌다.");
		}else if (you == computer) {
			System.out.println("비겼다");
		}else {
			System.out.println("이겼다");
		}// if 승패-출력
		} // if
	} // main
}// class