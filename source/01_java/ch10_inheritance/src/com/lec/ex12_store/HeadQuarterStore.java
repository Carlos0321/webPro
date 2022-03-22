package com.lec.ex12_store;

//º»»ç ÁöÄ§  : ±èÄ¡Âî°³-5,000  ºÎ´ëÂî°³-6,000  ºñºö¹ä-6,000 ¼ø´ë±¹-5,000  °ø±â¹ä-1,000¿ø
public class HeadQuarterStore {
	private String str; // "º»»ç"

	public HeadQuarterStore(String str) {
		this.str = str;
	}

	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ -5,000¿ø");
	}

	public void bude() {
		System.out.println("ºÎ´ëÂî°³ -6,000¿ø");
	}

	public void bibib() {
		System.out.println("ºñºö¹ä- 6,000¿ø");
	}

	public void sunde() {
		System.out.println("¼ø´ë±¹¹ä -5,000¿ø");
	}

	public void gonggibab() {
		System.out.println("°ø±â¹ä -1,000¿ø");
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
