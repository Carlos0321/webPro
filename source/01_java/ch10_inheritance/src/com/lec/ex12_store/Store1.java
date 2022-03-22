package com.lec.ex12_store;
//주택가에 매장1호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
public class Store1 extends HeadQuarterStore {

	public Store1(String str) {
		super(str);
	}
	@Override
	public void bude() {
//		super.bude();
		System.out.println("부대찌개 - 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국밥 안팔아");
	}
}
