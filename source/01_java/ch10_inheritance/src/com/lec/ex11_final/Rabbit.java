package com.lec.ex11_final;
//Animal로부터 speed, running(), stop() 상속 받음 
public final class Rabbit extends Animal {
	@Override
	public void running() {
		setSpeed(getSpeed()+30);  //speed += 30;
		System.out.println("마구 뛰어요. 현재속도 : " + getSpeed());
	}
}
