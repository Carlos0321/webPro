package com.lec.ex4_quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2_HashMap {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Member> members = new HashMap<String, Member>();
		do {
			System.out.print("회원가입 진행하시겠습니까(Y/N)? ");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")){ // 회원가입 진행
				System.out.print("가입하실 회원님 이름은 ?");
				name = scanner.next();
				System.out.print("가입하실 회원님 전화번호는 ?");
				phone = scanner.next();
				// 기존에 가입한 전화번호인지 확인하는 방법1
				if(members.get(phone) !=null) { 
					System.out.println("이미 가입되어 있는 전화번호입니다. 전화번호는 중복될 수 없습니다");
					continue;
				}
				// 기존에 가입한 전화번호인지 확인하는 방법2
//				Iterator<String> iterator = members.keySet().iterator();
//				boolean phoneChk = false;
//				while(iterator.hasNext()) {
//					String key = iterator.next();
//					if(members.get(key).getPhone().equals(phone)) {
//						phoneChk = true;
//						break;
//					}
//				}//while - 회원 목록에 해당 전화번호가 있는지?
//				if(phoneChk) {
//					System.out.println("이미 가입되어 있는 전화번호입니다. 전화번호는 중복될 수 없습니다");
//					continue;
//				}
				System.out.print("가입하실 회원님 주소는 ?");
				scanner.nextLine(); // 버퍼지우는 용도
				address = scanner.nextLine();
				members.put(phone, new Member(name, phone, address));
			}
		}while(true);
		scanner.close();
		if(members.isEmpty()) {
			System.out.println("☞ 가입한 회원이 없습니다 ☜");
		}else {
			System.out.println("☞ 가입한 회원 리스트 목록 ☜");
			Iterator<String> iterator = members.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(members.get(iterator.next()));
			}//while - 회원 목록 출력
		}//if - 가입한 회원 유무
	}
}
