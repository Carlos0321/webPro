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
		System.out.println("�ҳ�Ÿ�� ���̺긮�� �������� ��ü�ϰ� ���� 20km/1�� ��ü���ּ���  ");
		
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
