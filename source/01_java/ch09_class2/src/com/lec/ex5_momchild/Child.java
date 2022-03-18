package com.lec.ex5_momchild;
// Child first = new Child("첫쨰") ;
// first. takeMoney(1000) ; 엄마 천원만
public class Child {
	private String name ; 
	static MomPouch momPouch ;  //일반변수여서 돈이 창조됨  static 붙이면 
	public Child() {}
	public Child(String name) {
		this.name = name ;
		momPouch =	new MomPouch();
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name + "가" + money+ "원 가져가서 엄마 지갑에" + 
								momPouch.money + "원 있음");
		}else {
			System.out.println(name + "가 돈을 못 받음. 현재 엄마 지갑에는 " + momPouch.money + "원  밖에 없음");
		}//if
	}//takeMoney
}//main
