package com.lec.ex4;

import com.lec.cons.CarSpec;

public class TestMain {

	public static void main(String[] args) {
//		Car car = new LowGradeCar("회색", "일반", 1000, "일반");
//		Car car = new LowGradeCar(CarSpec.GRAY_Car, CarSpec.TIRE_NORMAL,
//									CarSpec.DISPLACEMENT_1000, CarSpec.HANDDLE_POWER);
		Car car = new HighGradeCar(CarSpec.WHITE_Car, CarSpec.TIRE_WIDE, CarSpec.DISPLACEMENT_2200,CarSpec.HANDDLE_POWER);
		
		car.getSpec();

	}

}
