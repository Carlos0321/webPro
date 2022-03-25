package strategy2_modularization;

import strategy2_interfaces.*;

// 3가지 부품 변수  /생성자 X / 메소드O drive(일반), shape(추상), engine(일반), km(일반) fuel(일반) / gettr&setter
public abstract class Car {
	private IEngine engine;
	private IFuel fuel;
	private IKm km;
	
	public void drive() {
		System.out.println("드라이브 할 수 있습니다 .");
	}
	public abstract void shape();
	
	public void engine() {
		engine.engine();
	}
	public void km() {
		km.km();
	}
	public void fuel() {
		fuel.fuel();
	}
	
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}
	public void setKm(IKm km) {
		this.km = km;
	}
	
	
}
