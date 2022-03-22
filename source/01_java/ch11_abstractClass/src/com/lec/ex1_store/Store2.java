package com.lec.ex1_store;
//2È£Á¡: ±èÄ¡Âî°³-5,000 ºÎ´ëÂî°³-5,000 ºñºö¹ä-5,000 ¼ø´ë±¹-5,000  °ø±â¹ä-¹«·á
public class Store2 extends HeadQuarterStore {

	public Store2(String str) {
		super(str);
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ - 5,000¿ø");
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä - 5,000¿ø");
	}
	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä - ¹«·á");
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°Ô - 5,000¿ø");
		
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹¹ä - 5,000¿ø");
		
	}
}
