package com.lec.ex;
// class : ������(�Ӽ� ,�ν��Ͻ�����)�� �޼ҵ�(���, setter, getter)  / Ÿ���� ���� ����ٰ� ���� 
// Car c = new Car()   //stack �޸𸮿� �ø�
// c.park
public class Car {
	private String color; //����
	private int cc; //��ⷮ
	private int speed; //�ӵ�
	public void drive() {
		speed =60;
		System.out.println(color +"�� ���� �����Ѵ�. ���ݼӵ� :" + speed);
	}
	public void park() {
		speed = 0;
		System.out.println(color +"�� ���� �����Ѵ�. ���ݼӵ� :" + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color +"�� ���� �����Ѵ�. ���ݼӵ� :" + speed);
	}
	// setter & getter (color, cc, speed)  setter �����ϱ� ���� 
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

