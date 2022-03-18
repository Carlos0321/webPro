package com.lec.ex6;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private String gender;

	public Member() {}

	public Member(String id, String pw, String name, String email, String adrress, String birth, String gender) {
		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = adrress;
		this.birth = birth;
		this.gender = gender;
	}
		
	public String infoString() {
		return String.format(" 아이디 = %s\n Pw = %s\n 이름 = %s\n Email = %s\n 주소 = %s\n 생일 = %s\n 성별 = %s자\n"
								,id , pw , name , email ,address, birth , gender);
		
	}
}
