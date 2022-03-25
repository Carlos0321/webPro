package strategy2_modularization;

import strategy2_interfaces.Km20;

public class TestMain {

	public static void main(String[] args) {
		
		Car[] cars = { new Genesis(), new Sonata(), new Accent()};

		for (Car c : cars) {
//			c.shape();
//			c.drive();
//			c.engine();
//			c.fuel();
//			c.km();
//			System.out.println("---------------------------");
		}
		System.out.println("소나타를 하이브리드 차량으로 교체하고 연비를 20km/1로 교체해주세요  ");
		
		cars[1].setFuel(new FuelHybrid());
		cars[1].setKm(new Km20());
		for(int idx=0; idx<cars.length ; idx++) {
			cars[idx].shape();
			cars[idx].drive();
			cars[idx].engine();
			cars[idx].fuel();
			cars[idx].km();
			System.out.println("========================");
		}
	}
}
