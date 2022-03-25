package strategy2_modularization;
// 상속받은 멤버 : // 3가지 부품 변수  /생성자 X / 메소드O drive(일반), shape(추상), engine(일반), km(일반) fuel(일반) / gettr&setter
import strategy2_interfaces.*;

public class Accent extends Car {
	public  Accent() {
		setEngine(new EngineLow());
		setKm(new Km10());
		setFuel(new FuelDiesel());
	}
	
	@Override
	public void shape() {
		System.out.println("액센트 모양은 door, sheet, handle로 이루어져 있습니다.");
	}

}
