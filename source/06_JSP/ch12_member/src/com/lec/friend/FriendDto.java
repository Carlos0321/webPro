package com.lec.friend;

public class FriendDto {
	private int n;
	private String fname;
	private String tel;
	public FriendDto() {}
	public FriendDto(int n, String fname, String tel) {
		this.n = n;
		this.fname = fname;
		this.tel = tel;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "FriendDto [n=" + n + ", fname=" + fname + ", tel=" + tel + "]";
	}
	
	
	
}
