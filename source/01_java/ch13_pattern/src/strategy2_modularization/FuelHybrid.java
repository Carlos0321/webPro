package strategy2_modularization;

import strategy2_interfaces.IFuel;

public class FuelHybrid implements IFuel {

	@Override
	public void fuel() {
		System.out.println("하이브리드 차량입니다.");
	}

}
