package com.lec.ex02_store;
// implements로 수정, str추가 ,생성자 수정, getter추가 
//3호점: 김치찌개-6,000 부대찌개-7,000 비빔밥-7,000 순대국-6,000  공기밥-1,000원
public class Store3 implements HeadQuarterStore {

	private String str;
	public Store3(String str) {
		this.str =str;
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 - 6,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 - 7,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 - 7,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국밥 - 6,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥 - 1,000원");
		
	}
	public String getStr() {
		return str;
	}
	
}
