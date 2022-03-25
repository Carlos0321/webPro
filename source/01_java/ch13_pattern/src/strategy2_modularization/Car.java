package strategy2_modularization;

import strategy2_interfaces.*;

// 3���� ��ǰ ����  /������ X / �޼ҵ�O drive(�Ϲ�), shape(�߻�), engine(�Ϲ�), km(�Ϲ�) fuel(�Ϲ�) / gettr&setter
public abstract class Car {
	private IEngine engine;
	private IFuel fuel;
	private IKm km;
	
	public void drive() {
		System.out.println("����̺� �� �� �ֽ��ϴ� .");
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
