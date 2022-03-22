package com.lec.ex1_store;
//HeadQuarterStore hstore = new HeadQuarterStore("본사") ; 객체 생성 불가 
//hstore.kimchi(); 불가
//본사 지침  : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public abstract class HeadQuarterStore {
	private String str; // "본사"

	public HeadQuarterStore(String str) {
		this.str = str;
	}
	//메소드 구현은 없고 선언만 되어 있는 메소드  : 추상메소드  (상속받은 클래스에서 오버라이드)
	//클래스 내 추상 메소드가 하나 이상일때 : 추상 클래스 
	public abstract void kimchi(); 

	public abstract void bude(); 

	public abstract void bibib(); 

	public abstract void sunde(); 

	public abstract void gonggibab(); 

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
