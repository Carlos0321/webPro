package com.lec.ex6;

public class MemberTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member = new Member("aaa", "xxx", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", "남");
		Member member1 = new Member("max9236", "abcd", "김민우", "max9236@naver.com", "서울 강남구", "1999-03-21", "남");
		Member[] info = {member,member1} ;
		
		for(int idx=0; idx < info.length; idx++) {
			System.out.println(info[idx].infoString());
		}
			
	}
}
