package com.lec.ex09_super;
// name, character, / intro()
// Baby b = new Baby ("홍아가", "이뻐");
// Baby b1 = new Baby() ;
public class Baby extends Person{
	public Baby() {
		System.out.println("매개변수 없는 Baby");
	}
	public Baby(String name, String character) {
		super(name, character);   //this나 super는 메소드의 맨 첫줄에 써야한다 
		setName(name); setCharacter(character);
		System.out.println("매개변수 있는 Baby생성자");
	}
	@Override
	public void intro() {
		System.out.println("응애 응애 난 아가야");
		super.intro();  //내 클래스의 슈퍼단의 intro() 
	}
}
