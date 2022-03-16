package com.lec.ex;
// class : 데이터(속성 ,인스턴스변수)와 메소드(기능, setter, getter)  / 타입을 새로 만든다고 생각 
// Car c = new Car()   //stack 메모리에 올림
// c.park
public class Car {
	private String color; //색상
	private int cc; //배기량
	private int speed; //속도
	public void drive() {
		speed =60;
		System.out.println(color +"색 차를 운전한다. 지금속도 :" + speed);
	}
	public void park() {
		speed = 0;
		System.out.println(color +"색 차를 주차한다. 지금속도 :" + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color +"색 차를 운전한다. 지금속도 :" + speed);
	}
	// setter & getter (color, cc, speed)  setter 세팅하기 위한 
	// myPorsche.methodName("red")  set+color => setColor
	// myPorsche.setColor("red")  
	public void setColor(String color) {
		this.color = color;
	}
	public void setCc(int cc ) { //myPorsche.setCc(1500)
		this.cc=cc;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// myPorsche.getColor()
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed; 
	}
	}


