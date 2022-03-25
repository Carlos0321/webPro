package strategy2_modularization;
// ��ӹ��� ��� : // 3���� ��ǰ ����  /������ X / �޼ҵ�O drive(�Ϲ�), shape(�߻�), engine(�Ϲ�), km(�Ϲ�) fuel(�Ϲ�) / gettr&setter
import strategy2_interfaces.*;

public class Sonata extends Car {
	public  Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.println("�ҳ�Ÿ ����� door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}
	
}
