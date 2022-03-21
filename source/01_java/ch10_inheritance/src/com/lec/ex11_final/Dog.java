package com.lec.ex11_final;
// Animal로부터 speed, running(), stop() 상속 받음 
public class Dog extends Animal {
	@Override
	public void running() {
		setSpeed(getSpeed()+10); //speed += 10;
		System.out.println("꼬리를 흔들며 뛰어요. 현재 속도 : "+getSpeed());
	}
}
