package com.lec.ex6;

public class MemberTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member = new Member("aaa", "xxx", "ȫ�浿", "hong@company.com", "���� ������", "2000-01-01", "��");
		Member member1 = new Member("max9236", "abcd", "��ο�", "max9236@naver.com", "���� ������", "1999-03-21", "��");
		Member[] info = {member,member1} ;
		
		for(int idx=0; idx < info.length; idx++) {
			System.out.println(info[idx].infoString());
		}
			
	}
}
