package com.lec.ex03_phone;
//b 제품 : DMB송수신기능, lte, TV리모콘 탑재 
public class BModel implements IAcorporation {
	private String modelName = "B모델" ;
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName +"은 DMB 송수신가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName +"은 LTE");
	}

	@Override
	public void tvRemotoeControl() {
		System.out.println(modelName +"은 TV리모콘 탑재");
	}

}
