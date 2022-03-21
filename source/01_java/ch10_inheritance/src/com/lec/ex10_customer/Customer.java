package com.lec.ex10_customer;
// name, tel, address, sum, point, date, vip
// Customer c = new Customer("홍" "010" "설" "1995-12-12")
public class Customer extends Person{
	private String address ;
	private int sum;     //구매누적금액
	private int point ;   
	private String date;  //기념일(Date타입될 예정)
	private boolean vip; // true면 vip false면 일반고객 
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);  //첫번째 라인에 와야함 
		this.address = address;
		this.date = date;
		point = 1000; //새 고객에는 1000포인트 자동부여 
		System.out.println(name + "님 감사감사. 포인트 1000점을 선물로");

	}
	public void buy(int price) {// c.buy(1000)
		sum += price;
		int temPoint = (int)(price*0.05);
		point += temPoint ;
		System.out.println(getName()+ "님 감사. 이번 구매로 포인트" + temPoint +"점 추가되어 총 포인트 : " + point);
		if(sum >= 1000000 && vip==false) {
			vip = true ; //구매누적금액이 100만원 이상시 vip 고객으로 
			System.out.println(getName() + "님 VIP고객으로 업그레이드 되셨습니다");
			
		}//if
	}//buy
	//c.print() vs sysout(c.infoString()) vs sysout(c)  / super.infoString() "[이름]홍 [전화]010-9999-9999
	//@: 어노테이션
	@Override
	public String infoString() {
		return super.infoString() + "[주소]"+ address+"[포인트}"+point+"[누적금액]"+sum;
	}
}
