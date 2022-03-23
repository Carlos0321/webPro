package com.lec.ex03_phone;
//a 제품 : DMB송수신기능, 5G, TV리모콘 탑재 
public class AModel implements IAcorporation {
	private String modelName;
	public AModel() {
		modelName = "A모델";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 송신 가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "은 5G");
	}

	@Override
	public void tvRemotoeControl() {
		System.out.println(modelName + "은 TV리모콘탑재");
	}

}
