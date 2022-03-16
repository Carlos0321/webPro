package com.lec.ex;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();    // Car =변수 타입   myPorsche :객채변수(instance)
		myPorsche.setColor("red");//myPorsche.color = "red";
		
		System.out.println(myPorsche.getColor()+ ""+
				"배기량 :" + myPorsche.getCc() + "속도 :" +myPorsche.getSpeed());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.getSpeed());
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray"); //yourPorsche
		
		yourPorsche.drive();
		yourPorsche.park();
		yourPorsche.race();
	}
}